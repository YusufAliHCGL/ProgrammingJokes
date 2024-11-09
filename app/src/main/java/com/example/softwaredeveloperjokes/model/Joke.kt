package com.example.softwaredeveloperjokes.model

import com.google.gson.annotations.SerializedName

data class Joke(
    @field:SerializedName(value = "category")
    val category: String,
    @field:SerializedName(value = "type")
    val type: String,
    @field:SerializedName(value = "joke")
    val joke: String? = null,
    @field:SerializedName(value = "setup")
    val setup: String? = null,
    @field:SerializedName(value = "delivery")
    val delivery: String? = null,
    @field:SerializedName(value = "flags")
    val flags: Flags,
    @field:SerializedName(value = "safe")
    val safe: Boolean,
    @field:SerializedName(value = "id")
    val apiId: Int,
    @field:SerializedName(value = "lang")
    val lang: String
)
