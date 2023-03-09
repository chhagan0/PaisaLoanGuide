package com.fliploan.guide.EMIs

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.fliploan.guide.ApplyLoan.BusinessLone
import com.fliploan.guide.ApplyLoan.PaydayLoan
import com.fliploan.guide.LoanInfo.PayDayLoanInfo
import com.fliploan.guide.R
import com.fliploan.guide.ads.Bannerad
import com.example.imp.ads.mainapp
import com.fliploan.guide.databinding.ActivityPaydayLoanEmiBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class PaydayLoanEmi : mainapp() {
    var binding: ActivityPaydayLoanEmiBinding?=null
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityPaydayLoanEmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
nativeads()
        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)
        binding.next.setOnClickListener { startActivity(Intent(this, PayDayLoanInfo::class.java)) }
        binding.backbtn.setOnClickListener { startActivity(Intent(this, PaydayLoan::class.java)) }
        binding!!.cheak.setOnClickListener { process() }
        binding!!.backbtn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    BusinessLone::class.java
                )
            )
        }
        binding!!.btn1.setOnClickListener {binding!!.input.setText("500000")
            binding!!.btn1.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding!!.btn2.setOnClickListener {binding!!.input.setText("1000000")
            binding!!.btn2.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding!!.btn3.setOnClickListener {binding!!.input.setText("1500000")
            binding!!.btn3.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding!!.btn4.setOnClickListener {binding!!.input.setText("2000000")
            binding!!.btn4.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }

        binding!!.btn5.setOnClickListener {binding!!.input.setText("3000000")
            binding!!.btn5.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding!!.btn6.setOnClickListener {binding!!.input.setText("5000000")
            binding!!.btn6.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding!!.btn7.setOnClickListener {binding!!.output.setText("3")
            binding!!.btn7.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn8.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn9.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn10.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn11.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding!!.btn8.setOnClickListener {binding!!.output.setText("6")
            binding!!.btn8.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn7.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn9.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn10.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn11.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding!!.btn9.setOnClickListener {binding!!.output.setText("12")
            binding!!.btn9.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn7.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn8.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn10.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn11.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding!!.btn10.setOnClickListener {binding!!.output.setText("24")
            binding!!.btn10.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn7.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn8.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn9.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn11.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding!!.btn11.setOnClickListener {binding!!.output.setText("24")
            binding!!.btn11.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn7.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn8.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn9.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn10.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding!!.btn12.setOnClickListener {binding!!.output.setText("48")
            binding!!.btn12.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn7.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn8.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn9.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn10.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn11.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }


    }

    private fun process() {
        val out=binding!!.output.text.toString().toInt()
        val inp=binding!!.input.text.toString().toInt()
        val res=inp / out
        if (res!=null){
            binding!!.total.setText("$res")

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