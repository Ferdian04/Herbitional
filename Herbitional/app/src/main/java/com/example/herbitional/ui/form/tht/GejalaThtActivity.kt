package com.example.herbitional.ui.form.tht

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.herbitional.databinding.ActivityGejalaThtactivityBinding
import com.example.herbitional.ui.form.kulit.GejalaKulitActivity
import com.example.herbitional.ui.form.mata.GejalaMataActivity
import com.example.herbitional.ui.form.otot.GejalaOtotSendiSarafActivity

class GejalaThtActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGejalaThtactivityBinding

    companion object{
        const val EXTRA_GEJALA_THT_RESULT = "extra_gejala_tht_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGejalaThtactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val result = checkBox()
            val intent = Intent(this@GejalaThtActivity, GejalaMataActivity::class.java)
            Log.e("GejalaTHTActivity", result)
            intent.putExtra(GejalaMataActivity.EXTRA_GEJALA_MATA_RESULT, result)
            startActivity(intent)
        }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun getPreviousData(): String{
        val data = intent.getStringExtra(EXTRA_GEJALA_THT_RESULT)
        if (data != null){
            return data
        } else {
            return ""
        }
    }

    private fun checkBox(): String{
        var tempResult = getPreviousData()
        with(binding){
            if (cbTenggorokanSakitMenelan.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if (cbPilek.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if (cbSuaraSerak.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if (cbSulitBernapas.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if (cbDenyutNadiLambat.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if (cbJantungBerdebar.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if (cbPernapasanLemah.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if (cbNapasTakTeratur.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }
            return tempResult
        }
    }
}