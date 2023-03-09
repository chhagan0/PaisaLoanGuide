package com.fliploan.guide.LoanInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fliploan.guide.ApplyLoan.*
import com.fliploan.guide.EMIs.BusinessLoanEmi
import com.fliploan.guide.databinding.ActivityBusinessLoaninfoBinding

class BusinessLoaninfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityBusinessLoaninfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.personal.setOnClickListener { startActivity(Intent(this, PersonalLoan::class.java)) }
        binding.car.setOnClickListener { startActivity(Intent(this, AutoLoan::class.java)) }
        binding.home.setOnClickListener { startActivity(Intent(this, HomeLoan::class.java)) }
        binding.business.setOnClickListener { startActivity(Intent(this, BusinessLone::class.java)) }
        binding.student.setOnClickListener { startActivity(Intent(this, SrudentLoan::class.java)) }
        binding.mortgages.setOnClickListener { startActivity(Intent(this, MortgagesLoan::class.java)) }
        binding.payday.setOnClickListener { startActivity(Intent(this, PaydayLoan::class.java)) }
        binding.smallbusiness.setOnClickListener { startActivity(Intent(this, SmallBusinessLoan::class.java)) }
        binding.backbtn.setOnClickListener { startActivity(Intent(this, BusinessLoanEmi::class.java)) }




    }
}