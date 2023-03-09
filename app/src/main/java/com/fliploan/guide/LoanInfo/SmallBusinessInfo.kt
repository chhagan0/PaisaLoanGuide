package com.fliploan.guide.LoanInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fliploan.guide.ApplyLoan.*
import com.fliploan.guide.EMIs.SmallBusinessEmi
import com.fliploan.guide.R
import com.fliploan.guide.databinding.ActivitySmallBusinessInfoBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class SmallBusinessInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivitySmallBusinessInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.car.setOnClickListener { startActivity(Intent(this, AutoLoan::class.java)) }
        binding.personal.setOnClickListener { startActivity(Intent(this, PersonalLoan::class.java)) }
        binding.home.setOnClickListener { startActivity(Intent(this, HomeLoan::class.java)) }
        binding.business.setOnClickListener { startActivity(Intent(this, BusinessLone::class.java)) }
        binding.student.setOnClickListener { startActivity(Intent(this, SrudentLoan::class.java)) }
        binding.mortgages.setOnClickListener { startActivity(Intent(this, MortgagesLoan::class.java)) }
        binding.payday.setOnClickListener { startActivity(Intent(this, PaydayLoan::class.java)) }
        binding.smallbusiness.setOnClickListener { startActivity(Intent(this, SmallBusinessLoan::class.java)) }
        binding.backbtn.setOnClickListener { startActivity(Intent(this, SmallBusinessEmi::class.java)) }
        nativeads()

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