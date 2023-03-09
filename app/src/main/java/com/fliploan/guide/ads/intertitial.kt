package com.fliploan.guide.ads

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.fliploan.guide.config.Ads
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

open class intertitial {

    companion object {

        var mInterstitialAd: InterstitialAd? = null

        fun load(context: Context) {
//id=   ca-app-pub-3940256099942544/1033173712

            val adRequest = AdRequest.Builder().build()
            InterstitialAd.load(
                context,
                Ads.interstitialId.toString(),
                adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        mInterstitialAd = null

                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        mInterstitialAd = interstitialAd


                    }
                })

        }


        fun showAds(context: Context, inte: Intent) {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(context as Activity)

                mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        super.onAdFailedToShowFullScreenContent(p0)
                    }

                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        context.startActivity(inte)
                    }
                }
            } else {
                context.startActivity(inte)

            }
        }
    }


}