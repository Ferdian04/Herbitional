package com.example.herbitional.ui.detail_history

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.herbitional.ViewModelVactory
import com.example.herbitional.data.Medicine
import com.example.herbitional.databinding.ActivityDetailHistoryBinding
import com.example.herbitional.ui.detail_medicine.DetailMedicineActivity
import com.example.herbitional.ui.home.RecomendationAdapter

class DetailHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHistoryBinding
    private val viewModel: DetailHistoryViewModel by viewModels {
        ViewModelVactory.getInstance(this)
    }

    companion object {
        const val EXTRA_MEDICINE_ID = "extra_medicine_id"
        const val EXTRA_HISTORY_ID = "extra_history_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        getDetailHistory()
        setupDetailHistory()

        binding.ivBack.setOnClickListener {
            finish()
        }

    }

    private fun getDetailHistory(){
        val detailHistory = intent.getIntExtra(EXTRA_HISTORY_ID, -1)
        if (detailHistory != -1){
            viewModel.getToken().observe(this){ token->
                if (token != null){
                    viewModel.getDetailHistory(token, detailHistory)
                }
            }
        }
    }

    private fun setupDetailHistory(){
        viewModel.detailHistory.observe(this){data ->
            binding.tvDiseaseName.text = data.namaPenyakit
            binding.tvDiseaseDescription1.text = data.deskripsiPenyakit1
            binding.tvDiseaseDescription2.text = data.deskripsiPenyakit2
            binding.tvDiseaseTreatment1.text = data.anjuranPenanganan1
            binding.tvDiseaseTreatment2.text = data.anjuranPenanganan2
        }
//        viewModel.loading.observe(this){
//                showLoading(it)
//        }
    }


//    private fun showLoading(state: Boolean) {
//        if (state) {
//            binding.progressBar.visibility = View.VISIBLE
//        } else {
//            binding.progressBar.visibility = View.GONE
//        }
//    }
}