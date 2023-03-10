package com.fliploan.guide

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.fliploan.guide.ads.Bannerad
import com.fliploan.guide.ads.intertitial
import com.example.imp.ads.mainapp
import com.fliploan.guide.databinding.ActivityEmicalculatorBinding
import com.google.android.gms.ads.AdRequest

class EMICalculator : mainapp() {
    lateinit var progress:ProgressDialog
    lateinit var binding: ActivityEmicalculatorBinding

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmicalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progress= ProgressDialog(this)
        progress.setMessage("Please wait...")
        progress.setCancelable(false)
        binding.cheak.setOnClickListener {
            showads()


        }
        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)
        binding.backbtn.setOnClickListener {

            val inte=(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )
            intertitial.showAds(this,inte)



        }
        binding.btn1.setOnClickListener {
            binding!!.input.setText("5000")
            binding!!.totalemi.setText("Rs. 5000")
            binding!!.btn1.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn2.setOnClickListener {
            binding!!.input.setText("10000")
            binding!!.totalemi.setText("Rs. 10000")
            binding!!.btn2.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn3.setOnClickListener {
            binding!!.input.setText("15000")
            binding!!.totalemi.setText("Rs. 15000")
            binding!!.btn3.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn4.setOnClickListener {
            binding!!.input.setText("25000")
            binding!!.totalemi.setText("Rs. 25000")
            binding!!.btn4.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }

        binding.btn5.setOnClickListener {
            binding!!.input.setText("35000")
            binding!!.totalemi.setText("Rs. 35000")
            binding!!.btn5.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn6.setOnClickListener {
            binding!!.input.setText("50000")
            binding!!.totalemi.setText("Rs. 50000")
            binding!!.btn6.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn13.setOnClickListener {
            binding!!.input.setText("75000")
            binding!!.totalemi.setText("Rs. 75000")
            binding!!.btn13.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn6.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn14.setOnClickListener {
            binding!!.input.setText("10000")
            binding!!.totalemi.setText("Rs. 100000")
            binding!!.btn14.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn15.setOnClickListener {
            binding!!.input.setText("500000")
            binding!!.totalemi.setText("Rs. 500000")
            binding!!.btn15.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn16.setOnClickListener {
            binding!!.input.setText("1000000")
            binding!!.totalemi.setText("Rs. 1000000")
            binding!!.btn16.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn17.setOnClickListener {
            binding!!.input.setText("5000000")
            binding!!.totalemi.setText("Rs. 5000000")
            binding!!.btn17.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn18.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn18.setOnClickListener {
            binding!!.input.setText("10000000")
            binding!!.totalemi.setText("Rs. 10000000")
            binding!!.btn18.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn1.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn2.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn3.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn4.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn5.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn13.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn14.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn15.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn16.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn17.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }

        binding.btn7.setOnClickListener {
            binding!!.output.setText("3")
            binding!!.btn7.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn8.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn9.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn10.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn11.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn8.setOnClickListener {
            binding!!.output.setText("6")
            binding!!.btn8.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn7.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn9.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn10.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn11.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn9.setOnClickListener {
            binding!!.output.setText("12")
            binding!!.btn9.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn7.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn8.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn10.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn11.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn10.setOnClickListener {
            binding!!.output.setText("24")
            binding!!.btn10.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn7.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn8.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn9.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn11.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn11.setOnClickListener {
            binding!!.output.setText("24")
            binding!!.btn11.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn7.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn8.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn9.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn10.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn12.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }
        binding.btn12.setOnClickListener {
            binding!!.output.setText("48")
            binding!!.btn12.setBackgroundColor(Color.parseColor("#03A9F4"))
            binding!!.btn7.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn8.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn9.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn10.setBackgroundColor(Color.parseColor("#E9E9E9"))
            binding!!.btn11.setBackgroundColor(Color.parseColor("#E9E9E9"))

        }


    }

    private fun showads() {
        progress.show()

        Handler(Looper.getMainLooper()).postDelayed({
            progress.dismiss()
            if (binding.input.text.isNotEmpty() || binding.output.text.isNotEmpty()){
                process()
                intrest()
            }else{

                Toast.makeText(this, "Select Loan type", Toast.LENGTH_SHORT).show()

            }

        }, 3000)

    }

    private fun process() {

        try {
            val out = binding.output.text.toString().toInt()
            val inp = binding.input.text.toString().toInt()
            val res = inp / out
            binding.monthlyemiamount.setText("$res")
        }catch (_:java.lang.NumberFormatException){}




    }

    private fun intrest() {


 try {
     val out = binding.output.text.toString().toInt()
     val inp = binding.input.text.toString().toInt()
     val int=(inp * out * 11.11)/100
     val intrest=int + inp
     binding.totalamount.text=(intrest.toString())

 }catch (_:java.lang.NumberFormatException){}


    }

}