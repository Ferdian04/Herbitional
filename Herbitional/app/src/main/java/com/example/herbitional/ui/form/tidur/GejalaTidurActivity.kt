package com.example.herbitional.ui.form.tidur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.herbitional.databinding.ActivityGejalaTidurBinding
import com.example.herbitional.ui.form.kulit.GejalaKulitActivity
import com.example.herbitional.ui.form.pencernaan.GejalaPencernaanActivity

class GejalaTidurActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGejalaTidurBinding

    companion object {
        const val EXTRA_GEJALA_TIDUR_RESULT = "extra_gejala_tidur_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGejalaTidurBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val result = checkBox()
            val intent = Intent(this@GejalaTidurActivity, GejalaPencernaanActivity::class.java)
            Log.e("GejalaTidurActivity", result)
            intent.putExtra(GejalaPencernaanActivity.EXTRA_GEJALA_PENCERNAAN_RESULT, result)
            startActivity(intent)
        }
        binding.ivBack.setOnClickListener {
            finish()
        }

    }

    private fun getPreviousData(): String{
        val data = intent.getStringExtra(EXTRA_GEJALA_TIDUR_RESULT)
        if (data != null){
            return data
        } else {
            return ""
        }
    }

    private fun checkBox(): String{
        var tempResult = getPreviousData()
        with(binding){
            if(cbSulitTidur.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbTertidurTiba2.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbMimpiBuruk.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }
            return tempResult
        }
    }
}