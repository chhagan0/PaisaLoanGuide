package com.fliploan.guide

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import com.fliploan.guide.ads.Bannerad
import com.fliploan.guide.ads.intertitial
import com.example.imp.ads.mainapp
import com.fliploan.guide.config.Ads
import com.fliploan.guide.databinding.ActivityInstantCashBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class InstantCash : mainapp() {
    var binding: ActivityInstantCashBinding?=null
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val progress: ProgressDialog

        binding =ActivityInstantCashBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
nativeads()
        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)
        progress = ProgressDialog(this)
        progress.setMessage("Please wait...")
        progress.setCancelable(false)
        binding!!.backbtn.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, MainActivity::class.java))
                intertitial.showAds(this,inte)

                finish()
            }, 5000)        }
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