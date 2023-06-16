package com.example.herbitional.api.response

import com.google.gson.annotations.SerializedName

data class SearchResponse(

	@field:SerializedName("input_text")
	val inputText: String,

	@field:SerializedName("predictions")
	val predictions: List<PredictionsItem>
)

data class PredictionsItem(

	@field:SerializedName("khasiat")
	val khasiat: String,

	@field:SerializedName("foto")
	val foto: String,

	@field:SerializedName("probability")
	val probability: Any,

	@field:SerializedName("efek_samping")
	val efekSamping: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("label")
	val label: String,

	@field:SerializedName("predicted_id")
	val predictedId: Int,

	@field:SerializedName("predicted_label")
	val predictedLabel: String
)
