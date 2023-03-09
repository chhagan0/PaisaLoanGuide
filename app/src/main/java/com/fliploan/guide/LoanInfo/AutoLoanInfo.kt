package com.fliploan.guide.LoanInfo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fliploan.guide.ApplyLoan.*
import com.fliploan.guide.EMIs.AutoLoanEmi
import com.fliploan.guide.R
import com.fliploan.guide.ads.intertitial
import com.fliploan.guide.databinding.ActivityAutoLoanInfoBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class AutoLoanInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAutoLoanInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.car.setOnClickListener {
            val inte = Intent(this, AutoLoan::class.java)
            intertitial.showAds(this, inte)
        }
        binding.personal.setOnClickListener {
            val inte =
                Intent(
                    this,
                    PersonalLoan::class.java
                )
            intertitial.showAds(this, inte)
        }
        binding.home.setOnClickListener {
            val inte = Intent(this, HomeLoan::class.java)
            intertitial.showAds(this, inte)
        }
        binding.business.setOnClickListener {
            val inte =
                Intent(
                    this,
                    BusinessLone::class.java
                )
            intertitial.showAds(this, inte)
        }
        binding.student.setOnClickListener {
            val inte = Intent(this, SrudentLoan::class.java)
            intertitial.showAds(this, inte)
        }
        binding.mortgages.setOnClickListener {
            val inte =
                Intent(
                    this,
                    MortgagesLoan::class.java
                )
            intertitial.showAds(this, inte)
        }
        binding.payday.setOnClickListener {
            val inte = Intent(this, PaydayLoan::class.java)
            intertitial.showAds(this, inte)
        }
        binding.smallbusiness.setOnClickListener {
            val inte =
                Intent(
                    this,
                    SmallBusinessLoan::class.java
                )
            intertitial.showAds(this, inte)
        }
        binding.backbtn.setOnClickListener {
            val inte = Intent(this, AutoLoanEmi::class.java)
            intertitial.showAds(this, inte)
        }

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