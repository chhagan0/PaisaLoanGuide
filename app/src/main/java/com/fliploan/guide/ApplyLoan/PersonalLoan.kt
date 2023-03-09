package com.fliploan.guide.ApplyLoan

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.imp.DataClass.Users
import com.example.imp.ads.mainapp
import com.fliploan.guide.Loantype
import com.fliploan.guide.ads.Bannerad
import com.fliploan.guide.ads.intertitial
import com.fliploan.guide.databinding.ActivityPersonalLoanBinding
import com.google.android.gms.ads.AdRequest
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PersonalLoan : mainapp() {
    private lateinit var progress: ProgressDialog
    lateinit var linkk: TextView

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPersonalLoanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Bannerad.mAdView = binding.adView
        FirebaseApp.initializeApp(this)
        linkk = binding.link


        progress = ProgressDialog(this)
        var firebaseAuth = FirebaseAuth.getInstance()
        progress?.setCancelable(false)
        progress?.setMessage("ADs Loading...")
        val adRequest = AdRequest.Builder().build()
        Bannerad.mAdView?.loadAd(adRequest)


        val databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val url = snapshot.getValue(Users::class.java)
                linkk.text = url!!.link
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        binding.applyforloan.setOnClickListener {
            webopen()
        }
        binding.backbtn.setOnClickListener {
            progress!!.show()
            if (intertitial.Companion.mInterstitialAd != null) {
                intertitial.mInterstitialAd?.show(this)
            }
            Handler(Looper.getMainLooper()).postDelayed({
                progress!!.dismiss()
                val inte =Intent(this, Loantype::class.java)
                intertitial.showAds(this, inte)



            }, 3000)
        }

    }

    private fun webopen() {
        progress!!.show()
        if (intertitial.Companion.mInterstitialAd != null) {
            intertitial.mInterstitialAd?.show(this)
        }
        Handler(Looper.getMainLooper()).postDelayed({
            progress.dismiss()

            val openuri = Intent(Intent.ACTION_VIEW)
            openuri.data = Uri.parse("${linkk.text.toString()}")
            intertitial.showAds(this, openuri)

            finish()
        }, 5000)
    }


}