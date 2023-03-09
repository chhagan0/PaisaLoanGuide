package com.fliploan.guide.ads

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import java.util.*

class AppOpenManager(private val myApplication: MyApplication, s: String) : Application.ActivityLifecycleCallbacks, LifecycleObserver{

    private var appOpenAd: AppOpenAd? = null
    private var loadCallback: AppOpenAd.AppOpenAdLoadCallback? = null
    private var currentActivity: Activity? = null
    private var isShowingAd = false

    private val adRequest: AdRequest
        get() = AdRequest.Builder().build()

    val isAdAvailable: Boolean
        get() = appOpenAd != null


    companion object {

        private  val AD_UNIT_ID = "ca-app-pub-3940256099942544/3419835294"
    }

    init {
        myApplication.registerActivityLifecycleCallbacks(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    fun fetchAd(){
        if(isAdAvailable){
            return
        }
        loadCallback = object : AppOpenAd.AppOpenAdLoadCallback(){
            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
            }

            override fun onAdLoaded(ad: AppOpenAd) {
                appOpenAd = ad
            }


        }
        val request = adRequest
        if (AD_UNIT_ID != null) {
            AppOpenAd.load(myApplication,
                AD_UNIT_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback as AppOpenAd.AppOpenAdLoadCallback
            )
        }
    }

    fun showAdIfAvailable(){
        if(!isShowingAd && isAdAvailable){
            Log.d("tag", "will show ad ")
            val fullScreenContentCallback: FullScreenContentCallback =
                object : FullScreenContentCallback(){
                    override fun onAdDismissedFullScreenContent() {
                        appOpenAd = null
                        isShowingAd = false
                        fetchAd()
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    }

                    override fun onAdShowedFullScreenContent() {
                        isShowingAd = true
                    }
                }
            currentActivity?.let { appOpenAd!!.show(it) }
        } else{
            Log.d("tag", "can't show ad ")
            fetchAd()
        }
    }



    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        showAdIfAvailable()

    }

    override fun onActivityStarted(activity: Activity) {
        currentActivity = activity
        onStart()
    }

    override fun onActivityResumed(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        currentActivity = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        showAdIfAvailable()
        Log.d("tag", "onStart: ")
    }
}