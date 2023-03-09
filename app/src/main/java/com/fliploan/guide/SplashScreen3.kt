package com.fliploan.guide

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import com.example.imp.ads.mainapp
import com.fliploan.guide.ads.intertitial
import com.fliploan.guide.databinding.ActivitySplashScreen3Binding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd

@SuppressLint("CustomSplashScreen")
class SplashScreen3 : mainapp() {
    private lateinit var progress: ProgressDialog


    private var mInterstitialAd: InterstitialAd? = null


    private var binding: ActivitySplashScreen3Binding? = null

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreen3Binding.inflate(layoutInflater)
        setContentView(binding!!.root)

        nativeads()
        progress = ProgressDialog(this)
        progress.setMessage(" Loading")
        progress.setCancelable(false)


        binding!!.nextbtn.setOnClickListener {
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte = Intent(this, MainActivity::class.java)
                intertitial.showAds(this, inte)

            }, 3000)


        }
        binding!!.share.setOnClickListener {
            progress.show()
            if (intertitial.mInterstitialAd != null) {
                intertitial.mInterstitialAd?.show(this)
            }
            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()


                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.putExtra(Intent.EXTRA_STREAM, "ali")
                shareIntent.type = "text/plain"
                startActivity(
                    Intent.createChooser(
                        shareIntent,
                        getResources().getText(R.string.app_name)
                    )
                )


                finish()
            }, 3000)


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
