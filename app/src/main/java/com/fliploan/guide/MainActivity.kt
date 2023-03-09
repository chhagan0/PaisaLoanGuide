package com.fliploan.guide

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.imp.ads.mainapp
import com.fliploan.guide.*
import com.fliploan.guide.ads.Bannerad
import com.fliploan.guide.ads.intertitial
import com.fliploan.guide.databinding.ActivityMainBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.gms.ads.*
import com.onesignal.OneSignal

class MainActivity : mainapp() {

    lateinit var binding: ActivityMainBinding
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private var progress: ProgressDialog? = null

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nativeads()
        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)


        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)



        progress = ProgressDialog(this)
        progress!!.setCancelable(false)
        progress!!.setMessage(" Loading...")


        setupdrawerlayout()

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {


            }
            true
        }
        binding.instantcash.setOnClickListener {
            progress!!.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()

                val inte = Intent(this, Loantype::class.java)

                intertitial.showAds(this, inte)

            }, 3000)
        }


        binding.nextcalculator.setOnClickListener {
            progress!!.show()


            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()

                val inte = Intent(this, EMICalculator::class.java)
                intertitial.showAds(this, inte)

            }, 3000)
        }
        binding.bank.setOnClickListener {
            progress!!.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()


                val inte = Intent(this, AllBanks::class.java)
                intertitial.showAds(this, inte)

            }, 3000)


        }
        binding.loanstatus.setOnClickListener {
            progress!!.show()


            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()

                val inte =Intent(this, LoanStatus::class.java)
                intertitial.showAds(this, inte)

            }, 3000)
        }
        binding.ifsccode.setOnClickListener {
            progress!!.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()

                val inte =Intent(this, IFSCcode::class.java)
                intertitial.showAds(this, inte)


            }, 3000)

        }
        binding.next.setOnClickListener {
            progress!!.show()
            if (intertitial.Companion.mInterstitialAd != null) {
                intertitial.mInterstitialAd?.show(this)
            }
            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()
                val inte =Intent(this, Loantype::class.java)
                        intertitial.showAds(this, inte)

            }, 3000)
        }
        binding.nextcounter.setOnClickListener {
            progress!!.show()


            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()

                val inte =Intent(this, CashCounter::class.java)
                intertitial.showAds(this, inte)

            }, 3000)
        }

    }


    fun setupdrawerlayout() {

        actionBarDrawerToggle =
            ActionBarDrawerToggle(
                this,
                binding.maindrawerlayout,

                com.fliploan.guide.R.string.app_name,
                com.fliploan.guide.R.string.app_name
            )
        setSupportActionBar(binding.appbar)
        binding.maindrawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val i = Intent()
        when (item.itemId) {
            com.fliploan.guide.R.id.loanstatusnav -> {
                i.setClass(this, Loantype::class.java)
                startActivity(i)
            }

        }
        val drawerLayout: DrawerLayout = binding.maindrawerlayout
        drawerLayout.closeDrawer(GravityCompat.START)


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun nativeads() {
        MobileAds.initialize(this)
        val adLoader = AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
            .forNativeAd { nativeAd ->
                val styles =
                    NativeTemplateStyle.Builder().build()
                val template = binding.myTemplate
                template.setStyles(styles)
                template.setNativeAd(nativeAd)
            }
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }

}
