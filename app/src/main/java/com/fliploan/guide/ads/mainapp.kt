package com.example.imp.ads

import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.fliploan.guide.ads.Bannerad
import com.fliploan.guide.ads.intertitial
import com.onesignal.OneSignal

open class mainapp :AppCompatActivity() {

    val ONESIGNAL_APP_ID = "5460b3df-c227-4f65-961a-854978587606"
    open var handler: android.os.Handler? = null

     override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

         OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

         OneSignal.initWithContext(this)
         OneSignal.setAppId(ONESIGNAL_APP_ID)

        intertitial.load(this)
        Bannerad.bannerads(this)
        checkConnectivity()
    }
    private fun checkConnectivity() {
        val manager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = manager.activeNetworkInfo

        if (null == activeNetwork) {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage("Make sure that WI-FI or mobile data is turned on, then try again")
                .setCancelable(false)
                .setPositiveButton("Retry", DialogInterface.OnClickListener { dialog, id ->
                    recreate()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                    finish()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("No Internet Connection")
            alert.setIcon(com.fliploan.guide.R.mipmap.ic_launcher)
            alert.show()
        }
    }
}