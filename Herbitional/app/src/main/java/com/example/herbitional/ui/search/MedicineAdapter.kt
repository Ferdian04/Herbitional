package com.example.herbitional.ui.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.herbitional.R
import com.example.herbitional.api.response.ArtikelItem
import com.example.herbitional.api.response.PredictionsItem
import com.example.herbitional.databinding.ItemMedicineBinding
import com.example.herbitional.ui.detail_medicine.DetailMedicineActivity

class MedicineAdapter(private val medicineList: List<PredictionsItem>) : RecyclerView.Adapter<MedicineAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ItemMedicineBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = medicineList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(medicineList[position])
    }

    class MyViewHolder(private val binding: ItemMedicineBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(listMedicineItem: PredictionsItem){
            binding.tvMedicineName.text = listMedicineItem.label
            binding.tvMedicineDescription.text = truncateText(listMedicineItem.deskripsi, 120)

            Glide.with(binding.root.context)
                .load(listMedicineItem.foto)
                .transform(CenterCrop(), RoundedCorners(30))
                .into(binding.ivMedicineImage)

            itemView.setOnClickListener {
                val intent =Intent(itemView.context, DetailMedicineActivity::class.java)
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