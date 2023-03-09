package com.fliploan.guide.ads

import android.app.Application
import com.google.android.gms.ads.MobileAds

open class MyApplication : Application() {
    private lateinit var appOpenManager: AppOpenManager

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)

        AppOpenManager(this, "ca-app-pub-3940256099942544/3419835294")
//        MobileAds.initialize(this){
//            Log.d("tag", "MobileAds init ")
//        }
//        appOpenManager = AppOpenManager(this)

    }


}