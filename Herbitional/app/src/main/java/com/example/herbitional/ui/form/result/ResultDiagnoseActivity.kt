package com.example.herbitional.ui.form.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.herbitional.MainActivity
import com.example.herbitional.R
import com.example.herbitional.ViewModelVactory
import com.example.herbitional.api.response.DataItem
import com.example.herbitional.databinding.ActivityResultDiagnoseBinding
import com.example.herbitional.ui.search.SearchFragment

class ResultDiagnoseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultDiagnoseBinding
    private val viewModel: ResultDiagnoseViewModel by viewModels {
        ViewModelVactory.getInstance(this)
    }

    companion object{
        const val EXTRA_DIAGNOSE_RESULT = "extra_diagnose_result"
    }

    var id_penyakit = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultDiagnoseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPredict()
        observeSave()
        binding.btnSave.setOnClickListener {
            saveHistory()
        }
    }

    private fun getPredict(){
        val data = intent.getParcelableExtra<DataItem>(EXTRA_DIAGNOSE_RESULT)
        if (data != null){
            binding.tvDiseaseName.text = data.namaPenyakit
            binding.tvDiseaseDescription1.text = data.deskripsiPenyakit1
            binding.tvDiseaseDescription2.text = data.deskripsiPenyakit2
            binding.tvDiseaseTreatment1.text = data.anjuranPenanganan1
            binding.tvDiseaseTreatment2.text = data.anjuranPenanganan2
            id_penyakit = data.idPenyakit
        }
    }

    private fun saveHistory(){
        viewModel.getToken().observe(this){
            if (id_penyakit != -1){
                viewModel.saveHistory(it,id_penyakit)
            }
        }
    }

    private fun observeSave(){
        viewModel.saveDiagnose.observe(this){data ->
            if (data != null){
                val intent = Intent(this@ResultDiagnoseActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }


}