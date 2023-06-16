package com.example.herbitional.ui.form.mata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.herbitional.databinding.ActivityGejalaMataBinding
import com.example.herbitional.ui.form.external.GejalaExternalActivity
import com.example.herbitional.ui.form.kulit.GejalaKulitActivity
import com.example.herbitional.ui.form.tht.GejalaThtActivity

class GejalaMataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGejalaMataBinding

    companion object{
        const val EXTRA_GEJALA_MATA_RESULT = "extra_gejala_mata_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGejalaMataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val result = checkBox()
            val intent = Intent(this@GejalaMataActivity, GejalaExternalActivity::class.java)
            Log.e("GejalaMataActivity", result)
            intent.putExtra(GejalaExternalActivity.EXTRA_GEJALA_EXTERNAL_RESULT, result)
            startActivity(intent)
        }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun getPreviousData(): String{
        val data = intent.getStringExtra(EXTRA_GEJALA_MATA_RESULT)
        if (data != null){
            return data
        } else {
            return ""
        }
    }

    private fun checkBox(): String {
        var tempResult = getPreviousData()
        with(binding) {
            if (cbSelaputPutihJadiKuning.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMataKering.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbKelopakMataGatal.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMataGatal.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbPengelihatanKabur.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMataBerair.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMataMerah.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbBenjolanDiKelopakTidakNyeri.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbBenjolanDiKelopakNyeri.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbBenjolanKemerahan.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMataBengkak.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMataPanas.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbKelopakMemerah.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMelihatLingkaranDiSekelilingCahaya.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbSensitifCahaya.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbPengelihatanDekatBuruk.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbPengelihatanJauhBuruk.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbPengelihatanGanda.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            if (cbMataNyeri.isChecked) {
                tempResult = "$tempResult,1"
            }else {
                tempResult = "$tempResult,0"
            }

            return tempResult
        }
    }
}