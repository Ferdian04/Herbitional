package com.example.herbitional.ui.form.otot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.herbitional.databinding.ActivityGejalaOtotSendiSarafBinding
import com.example.herbitional.ui.form.kulit.GejalaKulitActivity
import com.example.herbitional.ui.form.pencernaan.GejalaPencernaanActivity
import com.example.herbitional.ui.form.tht.GejalaThtActivity

class GejalaOtotSendiSarafActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_GEJALA_OTOT_RESULT = "extra_gejala_otot_result"
    }

    private lateinit var binding: ActivityGejalaOtotSendiSarafBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGejalaOtotSendiSarafBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val result = checkBox()
            val intent = Intent(this@GejalaOtotSendiSarafActivity, GejalaThtActivity::class.java)
            Log.e("GejalaOtotActivity", result)
            intent.putExtra(GejalaThtActivity.EXTRA_GEJALA_THT_RESULT, result)
            startActivity(intent)
        }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun getPreviousData(): String{
        val data = intent.getStringExtra(EXTRA_GEJALA_OTOT_RESULT)
        if (data != null){
            return data
        } else {
            return ""
        }
    }

    private fun checkBox(): String{
        var tempResult = getPreviousData()
        with(binding){
            if(cbNyeriPerut.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbNyeriPersendianTanganKaki.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbNyeriOtot.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbNyeriSendi.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbGerakanSendiTerbatas.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbAreaTerabaKeras.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbAreaMenegang.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbOtotTiba2Kontraksi.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbKekakuanSendi.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbNyeriBahu.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbKedutan.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbTubuhKejang.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }
            return tempResult
        }
    }
}