package com.example.herbitional.api.response

import com.google.gson.annotations.SerializedName

data class SaveHistoryResponse(

	@field:SerializedName("requestAt")
	val requestAt: String,

	@field:SerializedName("status")
	val status: String
)
