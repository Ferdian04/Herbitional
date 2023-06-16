package com.example.herbitional.ui.form.kulit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.herbitional.databinding.ActivityGejalaKulitBinding
import com.example.herbitional.ui.form.tidur.GejalaTidurActivity
import com.example.herbitional.ui.form.umum.GejalaUmumActivity

class GejalaKulitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGejalaKulitBinding


    companion object {
        const val EXTRA_GEJALA_KULIT_RESULT = "extra_gejala_kulit_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGejalaKulitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val result = checkBox()
            val intent = Intent(this@GejalaKulitActivity, GejalaTidurActivity::class.java)
            Log.e("GejalaKulitActivity", result)
            intent.putExtra(GejalaTidurActivity.EXTRA_GEJALA_TIDUR_RESULT, result)
            startActivity(intent)
        }
        binding.ivBack.setOnClickListener {
            finish()
        }

    }

    private fun getPreviousData(): String{
        val data = intent.getStringExtra(EXTRA_GEJALA_KULIT_RESULT)
        if (data != null){
            return data
        } else {
            return ""
        }
    }

    private fun checkBox(): String{
        var tempResult = getPreviousData()
        with(binding){
            if(cbInfeksiJamur.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbBenjolanKecilKeras.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbKemerahan.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbBengkak.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbBernanah.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbRuamCacing.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbAnusGatal.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbBercak.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbGatal.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbKulitKuning.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbIritasi.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbKulitKasar.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbMelepuh.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbMunculBenjolan.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbTonjolanCoklat.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbKulitBersisik.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }

            if(cbKeringatBerlebih.isChecked){
                tempResult = "$tempResult,1"
            }else{
                tempResult = "$tempResult,0"
            }
            return tempResult
        }
    }
}
