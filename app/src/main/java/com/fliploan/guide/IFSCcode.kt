package com.fliploan.guide

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.fliploan.guide.ads.intertitial
import com.fliploan.guide.ads.intertitial.Companion.mInterstitialAd
import com.example.imp.ads.mainapp
import com.fliploan.guide.config.Ads
import com.fliploan.guide.databinding.ActivityIfsccodeBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds


class IFSCcode : mainapp() {
    private var ifscCodeEdt: EditText? = null
    private var bankDetailsTV: TextView? = null
    var ifscCode: String? = null
   private var mRequestQueue: RequestQueue? = null
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val progress: ProgressDialog

        val binding= ActivityIfsccodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nativeads()
        progress = ProgressDialog(this)
        progress.setMessage("Please wait...")
        progress.setCancelable(false)
        binding.backbtn.setOnClickListener { progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                val inte=(Intent(this, MainActivity::class.java))
                intertitial.showAds(this,inte)

            }, 3000)

        }
        ifscCodeEdt = binding.idedtIfscCode
        val getBankDetailsBtn = binding.idBtnGetBankDetails
        bankDetailsTV = binding.idTVBankDetails
        mRequestQueue = Volley.newRequestQueue(this)
        getBankDetailsBtn.setOnClickListener{
            if (intertitial.Companion.mInterstitialAd!=null) {
                mInterstitialAd?.show(this)
            }
            progress.show()
            if (intertitial.Companion.mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            }
            Handler(Looper.getMainLooper()).postDelayed({
                progress.dismiss()
                ifscCode = ifscCodeEdt!!.text.toString()


                if (TextUtils.isEmpty(ifscCode)) {
                    Toast.makeText(
                        this,
                        "Please enter valid IFSC code",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {

                    getDataFromIFSCCode(ifscCode!!)
                }
            }, 3000)


        }
    }
    private fun getDataFromIFSCCode(ifscCode: String) {


        mRequestQueue!!.cache.clear()


        val url = "https://ifsc.razorpay.com/$ifscCode"

        val queue = Volley.newRequestQueue(this)


        val objectRequest =
            JsonObjectRequest(Request.Method.GET, url, null, { response ->

                try {

                    val bankName: String = response.getString("BANK")
                    val micr: String = response.getString("MICR")
                    val contact: String = response.getString("CONTACT")
                    val address: String = response.getString("ADDRESS")
                    val branch: String = response.getString("BRANCH")

                    bankDetailsTV!!.text =
                        "Bank Name : " + bankName + "\n" + "MICR Code : " + micr + "\nContact Number : " + contact + "\nAddress : " + address + "\nBranch : " + branch

                } catch (e: Exception) {

                    e.printStackTrace()
                }


            }) {
                bankDetailsTV!!.text = "Invalid IFSC Code"
            }

        queue.add(objectRequest)
    }
    private fun nativeads() {
        MobileAds.initialize(this)
        val adLoader = AdLoader.Builder(this,   Ads.nativeId.toString())
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