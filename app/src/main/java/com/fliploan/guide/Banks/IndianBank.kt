package com.fliploan.guide.Banks

import android.app.ProgressDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.fliploan.guide.MainActivity
 import com.fliploan.guide.ads.intertitial
import com.example.imp.ads.mainapp
 import com.fliploan.guide.R
import com.fliploan.guide.config.Ads
import com.fliploan.guide.databinding.ActivityIndianBankBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class IndianBank : mainapp() {
    lateinit var clipboardManager: ClipboardManager
    private lateinit var  progress: ProgressDialog
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityIndianBankBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nativeads()
        progress = ProgressDialog(this)
        progress?.setCancelable(false)
        progress?.setMessage("ADs Loading...")
        binding.backbtn.setOnClickListener {

            progress!!.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()
                val inte=(Intent(this, MainActivity::class.java))
                intertitial.showAds(this,inte)
            }, 3000)
        }

        binding.bank.setOnClickListener {
            clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val text=binding.number.text.toString()
            val clipData = ClipData.newPlainText("key", text)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(applicationContext, "Copied", Toast.LENGTH_SHORT).show()
        }

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