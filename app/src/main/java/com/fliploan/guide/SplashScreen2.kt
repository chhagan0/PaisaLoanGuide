package com.fliploan.guide

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import com.fliploan.guide.DataClass.Users
import com.example.imp.ads.mainapp
import com.fliploan.guide.ads.intertitial
import com.fliploan.guide.config.Ads
import com.fliploan.guide.databinding.ActivitySplashScreen2Binding
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class SplashScreen2 : mainapp() {

    private lateinit var progress: ProgressDialog

    private var binding: ActivitySplashScreen2Binding? = null
    private var mInterstitialAd: InterstitialAd? = null

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreen2Binding.inflate(layoutInflater)
        setContentView(binding!!.root)

        progress = ProgressDialog(this)
        progress?.setCancelable(false)
        progress?.setMessage(" Loading...")

        val adRequest = AdRequest.Builder().build()
        binding?.nextbtn?.setOnClickListener {
            progress!!.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte = Intent(this, SplashScreen3::class.java)
                intertitial.showAds(this, inte)
            }, 5000)


        }

        binding!!.privacypolicy.setOnClickListener {
            progress!!.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()

                val openuri = Intent(Intent.ACTION_VIEW)
                openuri.data = Uri.parse(Ads.baseurl2.toString())
                startActivity(openuri)
                intertitial.showAds(this, openuri)

            }, 5000)


        }

        binding!!.rotate.setOnClickListener {
            progress!!.show()
            if (intertitial.Companion.mInterstitialAd != null) {
                intertitial.mInterstitialAd?.show(this)
            }
            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()

                finish()
            }, 3000)

        }


    }


}
