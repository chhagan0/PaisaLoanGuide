package com.fliploan.guide.ApplyLoan

import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.imp.ads.mainapp
import com.fliploan.guide.EMIs.AutoLoanEmi
import com.fliploan.guide.Loantype
import com.fliploan.guide.ads.Bannerad
import com.fliploan.guide.ads.intertitial
import com.fliploan.guide.databinding.ActivityAutoLoanBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class AutoLoan : mainapp() {
    private lateinit var progress: ProgressDialog
    private var mInterstitialAd: InterstitialAd? = null

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAutoLoanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progress = ProgressDialog(this)
        progress?.setCancelable(false)
        progress?.setMessage("ADs Loading...")
        Bannerad.mAdView = binding.adView
        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)

        MobileAds.initialize(this) {}
        binding.applyforloan.setOnClickListener {
            progress!!.show()


            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()
                val inte = Intent(this, AutoLoanEmi::class.java)

                intertitial.showAds(this, inte)

            }, 3000)
        }
        binding.backbtn.setOnClickListener {
            progress!!.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()
                val inte = Intent(this, Loantype::class.java)
                intertitial.showAds(this, inte)

            }, 3000)
        }

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    adError?.toString()?.let { Log.d(ContentValues.TAG, it) }
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(ContentValues.TAG, "Ad was loaded.")
                    mInterstitialAd = interstitialAd
                }

            })
    }
}