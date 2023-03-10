package com.fliploan.guide.Banks

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
 import com.example.imp.ads.mainapp
 import com.fliploan.guide.R
import com.fliploan.guide.config.Ads
import com.fliploan.guide.databinding.ActivityIdbiBankBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class IdbiBank : mainapp() {
    lateinit var clipboardManager: ClipboardManager

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityIdbiBankBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nativeads()
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