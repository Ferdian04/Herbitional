package com.example.herbitional.ui.form.umum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.herbitional.databinding.ActivityGejalaUmumBinding
import com.example.herbitional.ui.form.kulit.GejalaKulitActivity

class GejalaUmumActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGejalaUmumBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGejalaUmumBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnNext.setOnClickListener {
            val result = checkBox()
            val intent = Intent(this@GejalaUmumActivity, GejalaKulitActivity::class.java)
            intent.putExtra(GejalaKulitActivity.EXTRA_GEJALA_KULIT_RESULT, result)
            startActivity(intent)
        }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }


//    private fun getPreviousData(): String{
//        val data = intent.getStringExtra(GejalaKulitActivity.EXTRA_RESULT)
//        if (data != null){
//            Log.e("GejalaUmumActivity", data)
//            return data
//        } else {
//            return ""
//        }
//    }

    private fun checkBox(): String{
        var tempResult = ""
        with(binding) {
            if (cbDiare.isChecked) {
                tempResult = "1"
            } else {
                tempResult = "0"
            }

            if(cbDemam.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbSakitPerut.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbCepatKenyang.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbPenuruanBeratBadan.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbMulutTerasaAsam.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbPenurunanNafsuMakan.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbMualMuntah.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbSakitKepala.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbRontok.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbKebotakan.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbMengantuk.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbSulitBerkonsentrasi.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbKeringatDingin.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbMenggigil.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }
            return tempResult
        }
    }
}