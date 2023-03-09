package com.fliploan.guide.ApplyLoan

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import com.fliploan.guide.EMIs.MortgagesLoanEmi
import com.fliploan.guide.Loantype
import com.fliploan.guide.ads.Bannerad
import com.fliploan.guide.ads.intertitial
import com.example.imp.ads.mainapp
 import com.fliploan.guide.databinding.ActivityMortgagesLoanBinding
import com.google.android.gms.ads.AdRequest

class MortgagesLoan : mainapp() {
    private lateinit var  progress: ProgressDialog
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivityMortgagesLoanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Bannerad.mAdView=binding.adView
        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)
        progress = ProgressDialog(this)
        progress?.setCancelable(false)
        progress?.setMessage("ADs Loading...")
        binding.applyforloan.setOnClickListener {
            progress!!.show()
            if (intertitial.Companion.mInterstitialAd != null) {
                intertitial.mInterstitialAd?.show(this)
            }
            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()
                startActivity(Intent(this, MortgagesLoanEmi::class.java))

                finish()
            }, 3000)}
        binding.backbtn.setOnClickListener {  progress!!.show()
            if (intertitial.Companion.mInterstitialAd != null) {
                intertitial.mInterstitialAd?.show(this)
            }
            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()
                startActivity(Intent(this, Loantype::class.java))

                finish()
            }, 3000)}
    }
}