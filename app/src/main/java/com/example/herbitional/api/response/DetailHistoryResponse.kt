package com.example.herbitional.api.response

import com.google.gson.annotations.SerializedName

data class DetailHistoryResponse(

	@field:SerializedName("artikel")
	val artikel: List<DiseaseItem>,

	@field:SerializedName("requestAt")
	val requestAt: String,

	@field:SerializedName("status")
	val status: String
)

data class DiseaseItem(

	@field:SerializedName("nama_penyakit")
	val namaPenyakit: String,

	@field:SerializedName("deskripsi_penyakit_2")
	val deskripsiPenyakit2: String,

	@field:SerializedName("deskripsi_penyakit_1")
	val deskripsiPenyakit1: String,

	@field:SerializedName("anjuran_penanganan_2")
	val anjuranPenanganan2: String,

	@field:SerializedName("id_penyakit")
	val idPenyakit: Int,

	@field:SerializedName("links-href")
	val linksHref: String,

	@field:SerializedName("anjuran_penanganan_1")
	val anjuranPenanganan1: String
)
