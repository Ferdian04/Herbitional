package com.example.herbitional.ui.profile

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.herbitional.R
import com.example.herbitional.api.response.DiseaseItem
import com.example.herbitional.api.response.RiwayatItem
import com.example.herbitional.databinding.ItemHistoryBinding
import com.example.herbitional.ui.detail_history.DetailHistoryActivity
import com.example.herbitional.ui.detail_medicine.DetailMedicineActivity

class HistoryAdapter(private val diseaseList: List<RiwayatItem> ) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = diseaseList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(diseaseList[position])

    }

}

class ViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(listHistoryItem: RiwayatItem){
        binding.tvDiseaseName.text = listHistoryItem.namaPenyakit

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, DetailHistoryActivity::class.java)
            intent.putExtra(DetailHistoryActivity.EXTRA_HISTORY_ID, listHistoryItem.idPenyakit)
            itemView.context.startActivity(intent)
        }
    }
}