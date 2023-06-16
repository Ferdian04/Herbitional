package com.example.herbitional.api.response

import com.google.gson.annotations.SerializedName

data class DetailMedicineResponse(

	@field:SerializedName("artikel")
	val artikel: List<DetailArtikelItem>,

	@field:SerializedName("requestAt")
	val requestAt: String,

	@field:SerializedName("status")
	val status: String
)

data class DetailArtikelItem(

	@field:SerializedName("khasiat")
	val khasiat: String,

	@field:SerializedName("foto_obat")
	val fotoObat: String,

	@field:SerializedName("efek_samping")
	val efekSamping: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("nama_obat")
	val namaObat: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String
)
