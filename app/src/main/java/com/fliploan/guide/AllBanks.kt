package com.fliploan.guide

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.annotation.RequiresApi
import com.fliploan.guide.ads.Bannerad
import com.fliploan.guide.ads.intertitial
import com.fliploan.guide.ads.intertitial.Companion.mInterstitialAd
import com.example.imp.ads.mainapp
 import com.fliploan.guide.Banks.*
import com.fliploan.guide.config.Ads
import com.fliploan.guide.databinding.ActivityAllBanksBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds


class AllBanks : mainapp() {
    lateinit var binding: ActivityAllBanksBinding
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val progress: ProgressDialog
         binding = ActivityAllBanksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progress = ProgressDialog(this)
        progress.setMessage("Please wait...")
        progress.setCancelable(false)


nativeads()

        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)

        val user = arrayOf("Allahabad","Andhra","Bank","Canara","Central","Federal","HDFC","ICIC","IDBI","Indian",
            "Indusind","Kotak","Pubjab","RBL","Saraswat","UCO", "Union","Yes")

        val userAdapter : ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,
            user
        )

val searchview=binding.searchView
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.searchView.clearFocus()
                if (user.contains(p0)){

                    userAdapter.filter.filter(p0)

                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                userAdapter.filter.filter(p0)
                return false            }

        })

        binding.backbtn.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, MainActivity::class.java))
                intertitial.showAds(this,inte)

            }, 3000)
        }


        binding.allahabad.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, AllhabadBank::class.java))
                intertitial.showAds(this,inte)

            }, 3000)

        }
        binding.andhrabank.setOnClickListener {

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, AndhraBank::class.java))
                intertitial.showAds(this,inte)

            }, 3000)
        }
        binding.boi.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, BankOfIndia::class.java))
                intertitial.showAds(this,inte)

            }, 3000)


        }
        binding.canarabank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, CanaraBank::class.java))
                intertitial.showAds(this,inte)


            }, 3000)
        }
        binding.centralboi.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, CentralBank::class.java))
                intertitial.showAds(this,inte)


            }, 3000)
        }
        binding.federalbank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, FederalBank::class.java))
                intertitial.showAds(this,inte)


            }, 3000)
        }
        binding.hdfcbank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, HdfcBank::class.java))
                intertitial.showAds(this,inte)


            }, 3000)
        }
        binding.icicbank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, IcicBank::class.java))
                intertitial.showAds(this,inte)


            }, 3000)
        }
        binding.idbibank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, IdbiBank::class.java))
                intertitial.showAds(this,inte)


            }, 3000)
        }
        binding.indianbank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, IndianBank::class.java))
                intertitial.showAds(this,inte)


            }, 3000)
        }
        binding.indusindbank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, IndusindBank::class.java))
                intertitial.showAds(this,inte)


            }, 3000)
        }
        binding.kotakbank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, KotakMahindraBank::class.java))
                intertitial.showAds(this,inte)


            }, 3000)
        }
        binding.pnb.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, PNB::class.java))
                intertitial.showAds(this,inte)

            }, 3000)
        }
        binding.rblbank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, RBLbank::class.java))
                intertitial.showAds(this,inte)

            }, 3000)
        }
        binding.sarawatbank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, SarswatBank::class.java))
                intertitial.showAds(this,inte)

            }, 3000)
        }
        binding.ucobank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, UCOBank::class.java))
                intertitial.showAds(this,inte)

            }, 3000)
        }
        binding.unionbank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, UnionBank::class.java))
                intertitial.showAds(this,inte)

                finish()
            }, 3000)
        }
        binding.yesbank.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, YesBank::class.java))
                intertitial.showAds(this,inte)

                finish()
            }, 3000)
        }

    }

    private fun nativeads() {
        MobileAds.initialize(this)
        val adLoader = AdLoader.Builder(this,   Ads.nativeId.toString())
            .forNativeAd { nativeAd ->
                val styles =
                    NativeTemplateStyle.Builder().build()
                val template = findViewById<TemplateView>(R.id.my_template)
                template.setStyles(styles)
                template.setNativeAd(nativeAd)
            }
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }
}