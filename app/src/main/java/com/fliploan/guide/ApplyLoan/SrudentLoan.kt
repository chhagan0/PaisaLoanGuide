package com.fliploan.guide.ApplyLoan

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import com.fliploan.guide.EMIs.StudentLoanEmi
import com.fliploan.guide.Loantype
 import com.fliploan.guide.ads.Bannerad
import com.fliploan.guide.ads.intertitial
import com.example.imp.ads.mainapp
import com.fliploan.guide.R
import com.fliploan.guide.config.Ads
import com.fliploan.guide.databinding.ActivitySrudentLoanBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class SrudentLoan : mainapp() {
    private lateinit var  progress: ProgressDialog
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivitySrudentLoanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)
nativeads()
        progress = ProgressDialog(this)
        progress?.setCancelable(false)
        progress?.setMessage("ADs Loading...")
        binding.applyforloan.setOnClickListener {  progress!!.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()
                val inte=(Intent(this, StudentLoanEmi::class.java))
                intertitial.showAds(this,inte)

            }, 3000)}
               binding.backbtn.setOnClickListener { progress!!.show()

                   Handler(Looper.getMainLooper()).postDelayed({
                       progress!!.dismiss()
                       val inte=(Intent(this, Loantype::class.java))
                       intertitial.showAds(this,inte)

                   }, 3000)}

    }
    private fun nativeads() {
        MobileAds.initialize(this)
        val adLoader = AdLoader.Builder(this, Ads.nativeId.toString())
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