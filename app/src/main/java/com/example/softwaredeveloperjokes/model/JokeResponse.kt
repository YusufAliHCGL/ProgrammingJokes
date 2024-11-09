package com.example.softwaredeveloperjokes.model

import com.google.gson.annotations.SerializedName

data class JokeResponse(
    @field:SerializedName(value = "error")
    val error: Boolean,
    @field:SerializedName(value = "amount")
    val amount: Int,
    @field:SerializedName(value = "jokes")
    val jokes: List<Joke>
)
