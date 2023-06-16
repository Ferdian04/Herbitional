package com.example.herbitional.ui.detail_medicine

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.herbitional.ViewModelVactory
import com.example.herbitional.databinding.ActivityDetailMedicineBinding

class DetailMedicineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMedicineBinding
    private val viewModel: DetailMedicineViewModel by viewModels {
        ViewModelVactory.getInstance(this)
    }

    companion object{
        const val EXTRA_MEDICINE_ID = "extra_medicine_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMedicineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        getDetailMedicine()
        setupDetailMedicine()

    }

    private fun getDetailMedicine(){
        val detailMedicine = intent.getIntExtra(EXTRA_MEDICINE_ID, -1)
        if (detailMedicine != -1){
            viewModel.getToken().observe(this){ token->
                if (token != null){
                    viewModel.getDetailMedicine(token, detailMedicine)
                }
            }
        }
    }

    private fun setupDetailMedicine(){
        viewModel.detailArtikel.observe(this){data ->
            if(data != null){
                Glide
                    .with(this)
                    .load(data.fotoObat)
                    .centerCrop()
                    .into(binding.ivDetailMedicine)

                binding.tvMedicineName.text = data.namaObat
                binding.tvMedicineDescription.text = data.deskripsi
                binding.tvMedicineEfficacy.text = data.khasiat
                binding.tvMedicineSideEffect.text = data.efekSamping

            }
            viewModel.loading.observe(this){
                showLoading(it)
            }
        }
    }

    private fun showLoading(state: Boolean){
        if(state){
            binding.progressBar.visibility = View.VISIBLE
            binding.tvTitleMedEfficacy.visibility = View.GONE
            binding.tvTitleMedSideEffect.visibility = View.GONE
            binding.tvMedicineName.visibility = View.GONE
        }else{
            binding.progressBar.visibility = View.GONE
            binding.tvTitleMedEfficacy.visibility = View.VISIBLE
            binding.tvTitleMedSideEffect.visibility = View.VISIBLE
            binding.tvMedicineName.visibility = View.VISIBLE
        }
    }


}