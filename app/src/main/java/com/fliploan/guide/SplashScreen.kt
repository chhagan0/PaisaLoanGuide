package com.fliploan.guide

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.fliploan.guide.config.Ads
import com.fliploan.guide.databinding.ActivitySplashScreenBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class SplashScreen : AppCompatActivity() {
    var isStarted = false
    var progressStatus = 0
    var secondaryHandler: Handler? = Handler()
    var secondaryProgressStatus = 0
    var handler = android.os.Handler()

    private lateinit var binding: ActivitySplashScreenBinding

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)






        handler = Handler {
            if (isStarted) {
                progressStatus++
            }
            binding.progressBarHorizontal.progress = progressStatus
            handler?.sendEmptyMessageDelayed(0, 4400)

            true
        }

        handler?.sendEmptyMessage(0)


        if (checkForInternet(this)) {

            getData()

        } else {
            AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("No Internet")
                .setMessage("You have not any active internet connection.\n Please turn on.")
                .setPositiveButton("Exit") { _, _ ->
                    finishAffinity()
                }.show()
        }

//        loadprograss()

    }

    private var countDownTimer: CountDownTimer? = null

    private var timerRunning = false
    private var isOpen = false
    private var timeLeftInMillis: Long = 60000
    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                //      updateCountdownText()
            }

            override fun onFinish() {
                timerRunning = false
                // Do something when the timer finishes
            }
        }.start()
        timerRunning = true
    }

    private fun loadprograss() {
        Thread {
            while (secondaryProgressStatus < 100) {
                secondaryProgressStatus += 1

                try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                secondaryHandler?.post {
                    binding.progressBarHorizontal.secondaryProgress = secondaryProgressStatus


                    startActivity(Intent(this, SplashScreen2::class.java))

                }
            }
        }.start()

    }


    private fun checkForInternet(context: Context): Boolean {

        // register activity with the connectivity manager service
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }


    private fun getData() {

        val preference = getSharedPreferences("config", Context.MODE_PRIVATE)
        val editor = preference.edit()


        FirebaseDatabase.getInstance().reference.child("config")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val url = snapshot.getValue(Ads::class.java)

                    val data: String =
                        snapshot.child("appOpenId").getValue(String::class.java).toString()
                    val bannerId: String =
                        snapshot.child("appBannerId").getValue(String::class.java).toString()
                    val interstitialId: String =
                        snapshot.child("appInterstialId").getValue(String::class.java).toString()
                    val baseurl1: String =
                        snapshot.child("appbaseurl1").getValue(String::class.java).toString()
                    val baseurl2: String =
                        snapshot.child("appbaseurl2").getValue(String::class.java).toString()
                    val nativeId: String =
                        snapshot.child("appNativeId").getValue(String::class.java).toString()
                    url!!.appopnid = data
                    url.bannerId = bannerId
                    url.interstitialId = interstitialId
                    url.baseurl1 = baseurl1
                    url.baseurl2 = baseurl2
                    url.nativeId=nativeId


                    val dataMap = snapshot.value as HashMap<String, Any>
                    isOpen = true

                    editor.putString("appOpenId", dataMap.getValue("appOpenId").toString())
                    editor.putString("appBannerId", dataMap.getValue("appBannerId").toString())
//                    editor.putString("bannerId2", dataMap.getValue("bannerId2").toString())
                    editor.putString("appbaseurl1", dataMap.getValue("appbaseurl1").toString())
                    editor.putString(
                        "appInterstialId",
                        dataMap.getValue("appInterstialId").toString()
                    )
//                    editor.putString("interstitialId2", dataMap.getValue("interstitialId2").toString())
//                    editor.putString("baseurl2", dataMap.getValue("baseurl2").toString())
                    editor.putString("appNativeId", dataMap.getValue("appNativeId").toString())
//                    editor.putString("nativeId2", dataMap.getValue("nativeId2").toString())
//                    editor.putString("help", dataMap.getValue("help").toString())
                    editor.apply()

                    openActivity()
                    Log.d("SHUBH", "onDataChange: " + dataMap.getValue("appNativeId").toString())

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@SplashScreen, "Something went wrong.", Toast.LENGTH_SHORT)
                        .show()
                }

            })
    }

    fun openActivity() {
//        Handler(mainLooper).postDelayed({
        if (isOpen && !timerRunning) {
            startActivity(Intent(this, SplashScreen2::class.java))
            finish()

//        },3000)

        }

    }
}