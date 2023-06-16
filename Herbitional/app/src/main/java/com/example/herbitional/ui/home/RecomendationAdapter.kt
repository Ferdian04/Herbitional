package com.example.herbitional.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.herbitional.api.response.ArtikelItem
import com.example.herbitional.api.response.PredictionsItem
import com.example.herbitional.databinding.ItemMedicineBinding
import com.example.herbitional.ui.detail_medicine.DetailMedicineActivity
import kotlin.math.truncate

class RecomendationAdapter(private val medicineList: List<ArtikelItem>) : RecyclerView.Adapter<RecomendationAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ItemMedicineBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = medicineList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(medicineList[position])

    }

    class MyViewHolder(private val binding: ItemMedicineBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listMedicineItem: ArtikelItem){
            binding.tvMedicineName.text = listMedicineItem.namaObat
            binding.tvMedicineDescription.text = truncateText(listMedicineItem.deskripsi, 120)

            Glide.with(binding.root.context)
                .load(listMedicineItem.fotoObat)
                .transform(CenterCrop(), RoundedCorners(30))
                .into(binding.ivMedicineImage)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailMedicineActivity::class.java)
                intent.putExtra(DetailMedicineActivity.EXTRA_MEDICINE_ID, listMedicineItem.id)
                itemView.context.startActivity(intent)
            }

        }

        private fun truncateText(text: String, maxLength: Int): String {
            return if (text.length > maxLength) {
                text.substring(0, maxLength) + "... selengkapnya" // Tambahkan tanda titik-titik setelah batas karakter
            } else {
                text
            }
        }
    }


}