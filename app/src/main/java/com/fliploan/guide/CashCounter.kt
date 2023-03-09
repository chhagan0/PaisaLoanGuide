package com.fliploan.guide

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.fliploan.guide.ads.intertitial
import com.example.imp.ads.mainapp
import com.fliploan.guide.databinding.ActivityCashCounterBinding

class CashCounter : mainapp() {
    lateinit var binding: ActivityCashCounterBinding
    var count:Int=0
    var fiveh:Int=0
    var twoh:Int=0
    var oneh:Int=0
    var fiftyh:Int=0
    var fifty:Int=50
    var twentyh:Int=0
    var tenh:Int=0
    var ten:Int=10
    var twenty:Int=20
    var a:Int=2000
    var five:Int=500
    var two:Int=200
    var one:Int=100

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding=ActivityCashCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backbtn.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
        binding.plus.setOnClickListener {count=(count+a)
            resulttwot() }
        binding.minus.setOnClickListener {  count=(count-a)
            resulttwot() }

        binding.fiveminus.setOnClickListener { fiveh=(fiveh-five)
        fivehund()}
        binding.fiveplus.setOnClickListener { fiveh=(fiveh+five)
        fivehund()}

        binding.twohundredplus.setOnClickListener { twoh=(twoh+two)
            resulttwo()}
        binding.twohundredminus.setOnClickListener { twoh=(twoh-two)
            resulttwo()}

        binding.onehundredplus.setOnClickListener { oneh=(oneh+one)
        onehundredr()}
        binding.onehundredminus.setOnClickListener { oneh=(oneh-one)
        onehundredr()}

        binding.fiftyplus.setOnClickListener { fiftyh=(fiftyh+fifty)
        fiftyr()}
        binding.fiftyminus.setOnClickListener { fiftyh=(fiftyh-fifty)
            fiftyr()}

        binding.twentyminus.setOnClickListener { twentyh=(twentyh-twenty)
        twentyr()}
        binding.twentyplus.setOnClickListener { twentyh=(twentyh+twenty)
            twentyr()}

        binding.tenplus.setOnClickListener { tenh=(tenh+ten)
        tenr()}
        binding.tenminus.setOnClickListener { tenh=(tenh-ten)
            tenr()}
binding.copy.setOnClickListener {  updatetotal()}
        binding.share.setOnClickListener { showSharingDialog() }

    }

    private fun tenr() {
        binding.ten.text=tenh.toString()
    }

    private fun twentyr() {
        binding.twenty.text=twentyh.toString()
    }

    private fun fiftyr() {
        binding.fifty.text=fiftyh.toString()
    }

    private fun onehundredr() {
        binding.onehundred.text=oneh.toString()
    }

    private fun resulttwo() {
        binding.twohundred.text=twoh.toString()
    }

    private fun updatetotal() {
        val one= binding.twothousand.text.toString().toInt()
        val two= binding.fivehundred .text.toString().toInt()
        val three= binding.twohundred .text.toString().toInt()
        val four= binding.onehundred .text.toString().toInt()
        val five= binding.fifty .text.toString().toInt()
        val six= binding.twenty .text.toString().toInt()
        val seven= binding.ten .text.toString().toInt()

        val result = one + two +three +four +five +six +seven
        binding.total.text=result.toString()
    }

    private fun fivehund(){
    binding.fivehundred.text=fiveh.toString()
}

    private fun resulttwot() {
        binding.twothousand.text=count.toString()
    }


        fun showSharingDialog() {
            val text=binding.total.text.toString().toInt()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(Intent.createChooser(intent, "Share with:"))
            if (intertitial.Companion.mInterstitialAd!=null) {
                intertitial.mInterstitialAd?.show(this)
            }
        }

}