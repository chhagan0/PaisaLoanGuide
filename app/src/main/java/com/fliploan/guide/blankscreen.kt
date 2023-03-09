package com.fliploan.guide

import android.content.Intent
import android.os.Bundle
import com.fliploan.guide.ads.Bannerad
import com.example.imp.ads.mainapp

import com.fliploan.guide.databinding.ActivityBlankscreenBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class blankscreen : mainapp() {
    var binding: ActivityBlankscreenBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blankscreen)
        binding = ActivityBlankscreenBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
nativeads()
        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)
        binding!!.backbtn.setOnClickListener {
            startActivity(Intent(this, InstantCash::class.java))
        }
    }
    private fun nativeads() {
        MobileAds.initialize(this)
        val adLoader = AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
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