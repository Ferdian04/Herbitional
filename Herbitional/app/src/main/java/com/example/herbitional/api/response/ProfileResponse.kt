package com.example.herbitional.api.response

import com.google.gson.annotations.SerializedName

data class ProfileResponse(

	@field:SerializedName("user_email")
	val userEmail: String,

	@field:SerializedName("riwayat")
	val riwayat: List<RiwayatItem>,

	@field:SerializedName("fullname")
	val fullname: String,

	@field:SerializedName("requestAt")
	val requestAt: String,

	@field:SerializedName("status")
	val status: String
)

data class RiwayatItem(

	@field:SerializedName("nama_penyakit")
	val namaPenyakit: String,

	@field:SerializedName("id_penyakit")
	val idPenyakit: Int,

	@field:SerializedName("id_riwayat")
	val idRiwayat: Int
)
