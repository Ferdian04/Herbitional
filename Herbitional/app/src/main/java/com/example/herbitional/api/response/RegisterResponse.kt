package com.example.herbitional.api.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("requestAt")
	val requestAt: String,

	@field:SerializedName("status")
	val status: String
)
