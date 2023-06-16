package com.example.herbitional.ui.form.external

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.herbitional.databinding.ActivityGejalaExternalBinding
import com.example.herbitional.ui.form.kulit.GejalaKulitActivity
import com.example.herbitional.ui.form.lain.GejalaLainnyaActivity
import com.example.herbitional.ui.form.mata.GejalaMataActivity

class GejalaExternalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGejalaExternalBinding

    companion object{
        const val EXTRA_GEJALA_EXTERNAL_RESULT = "extra_gejala_external_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGejalaExternalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val result = checkBox()
            val intent = Intent(this@GejalaExternalActivity, GejalaLainnyaActivity::class.java)
            Log.e("GejalaMataActivity", result)
            intent.putExtra(GejalaLainnyaActivity.EXTRA_GEJALA_LAINNYA_RESULT, result)
            startActivity(intent)
        }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun getPreviousData(): String{
        val data = intent.getStringExtra(EXTRA_GEJALA_EXTERNAL_RESULT)
        if (data != null){
            return data
        } else {
            return ""
        }
    }

    private fun checkBox(): String {
        var tempResult = getPreviousData()
        with(binding) {
            if (cbMalnutrisi.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbTempatKurangSanitasi.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMakananMinumanTinggiPurin.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMakananMinumanTidakDiolahDenganTepat.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMakananMinumanKadaluwarsa.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMakananPanas.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbTerkenaUdaraDinginPanas.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbTerpaparSinarMatahari.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbLembab.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbDehidrasi.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            return tempResult
        }
    }
}