package com.fliploan.guide.ads

import android.content.Context
import com.fliploan.guide.config.Ads
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

open class Bannerad {
    companion object{

       open  var mAdView: AdView?=null

         fun bannerads(context:Context) {
            val adView = AdView(context)
//            mAdView = binding.adView
            adView.adUnitId = Ads.bannerId.toString()
            MobileAds.initialize(context) {}

//            mAdView = binding.adView
            val adRequest = AdRequest.Builder().build()
            mAdView?.loadAd(adRequest)
        }

    }


}