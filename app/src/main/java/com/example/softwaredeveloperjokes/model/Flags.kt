package com.example.softwaredeveloperjokes.model

import com.google.gson.annotations.SerializedName

data class Flags(
	@field:SerializedName("sexist")
	val sexist: Boolean,

	@field:SerializedName("explicit")
	val explicit: Boolean,

	@field:SerializedName("religious")
	val religious: Boolean,

	@field:SerializedName("nsfw")
	val nsfw: Boolean,

	@field:SerializedName("political")
	val political: Boolean,

	@field:SerializedName("racist")
	val racist: Boolean
)
