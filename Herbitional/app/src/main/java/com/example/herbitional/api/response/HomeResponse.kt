package com.example.herbitional.api.response

import com.google.gson.annotations.SerializedName

data class HomeResponse(

	@field:SerializedName("artikel")
	val artikel: List<ArtikelItem>,

	@field:SerializedName("requestAt")
	val requestAt: String,

	@field:SerializedName("status")
	val status: String
)

data class ArtikelItem(

	@field:SerializedName("foto_obat")
	val fotoObat: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("nama_obat")
	val namaObat: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String
)
