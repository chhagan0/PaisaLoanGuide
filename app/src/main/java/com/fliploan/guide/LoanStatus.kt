package com.fliploan.guide

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.annotation.RequiresApi
import com.fliploan.guide.ads.Bannerad
import com.fliploan.guide.ads.intertitial
import com.fliploan.guide.ads.intertitial.Companion.mInterstitialAd
import com.example.imp.ads.mainapp
import com.fliploan.guide.databinding.ActivityLoanStatusBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class LoanStatus : mainapp() {
    var progress: ProgressDialog?=null
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoanStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progress?.setMessage("Please wait...")
        progress?.setCancelable(false)
nativeads()
        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)
    }

    fun apply(view: View) {
        progress?.show()
        if (intertitial.Companion.mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
        Handler(Looper.getMainLooper()).postDelayed({
            progress?.dismiss()
            startActivity( Intent(   this, Loantype::class.java ))

            finish()
        }, 3000)
        progress?.show()

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