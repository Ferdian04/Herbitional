package com.example.herbitional.api.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class PredictResponse(

	@field:SerializedName("data")
	val data: List<DataItem>
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("nama_penyakit")
	val namaPenyakit: String,

	@field:SerializedName("deskripsi_penyakit_2")
	val deskripsiPenyakit2: String,

	@field:SerializedName("deskripsi_penyakit_1")
	val deskripsiPenyakit1: String,

	@field:SerializedName("anjuran_penanganan_2")
	val anjuranPenanganan2: String,

	@field:SerializedName("anjuran_penanganan_1")
	val anjuranPenanganan1: String,

	@field:SerializedName("id_penyakit")
	val idPenyakit: Int,

	@field:SerializedName("links-href")
	val linksHref: String
) : Parcelable
