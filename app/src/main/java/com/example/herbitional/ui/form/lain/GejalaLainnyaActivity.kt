package com.example.herbitional.ui.form.lain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.herbitional.ViewModelVactory
import com.example.herbitional.databinding.ActivityGejalaLainnyaBinding
import com.example.herbitional.ui.form.external.GejalaExternalActivity
import com.example.herbitional.ui.form.kulit.GejalaKulitActivity
import com.example.herbitional.ui.form.result.ResultDiagnoseActivity

class GejalaLainnyaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGejalaLainnyaBinding
    private val viewModel: GejalaLainnyaViewModel by viewModels {
        ViewModelVactory.getInstance(this)
    }

    companion object{
        const val EXTRA_GEJALA_LAINNYA_RESULT = "extra_gejala_lainnya_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGejalaLainnyaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPredict()

        binding.btnDiagnose.setOnClickListener {
            postPredict()

        }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun postPredict(){
        val symptoms = checkBox()
        Log.e("GejalaLainnya", symptoms)
        viewModel.getPredict(symptoms)
    }

    private fun getPredict(){
        viewModel.predict.observe(this){data ->
            if (data != null){
                val intent = Intent(this@GejalaLainnyaActivity, ResultDiagnoseActivity::class.java)
                intent.putExtra(ResultDiagnoseActivity.EXTRA_DIAGNOSE_RESULT, data)
                startActivity(intent)
            }
        }
    }



    private fun getPreviousData(): String{
        val data = intent.getStringExtra(EXTRA_GEJALA_LAINNYA_RESULT)
        if (data != null){
            return data
        } else {
            return ""
        }
    }

    private fun checkBox(): String {
        var tempResult = getPreviousData()
        with(binding) {
            if (cbRiwayatAsamUratGenetik.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbAnemiaBerat.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbBerusia56Tahun.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbKakiGajah.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbPerutBengkak.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbStress.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbPerubahanEmosi.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMulutKeluarBusa.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbHalusinasi.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbHabisBepergian.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbDemamTinggi.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbKehilanganKesadaran.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbHamil.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            return tempResult
        }
    }
}