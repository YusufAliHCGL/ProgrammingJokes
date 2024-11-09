package com.example.softwaredeveloperjokes.viewmodel

import com.example.softwaredeveloperjokes.model.JokeResponse

data class JokeState(
    val isLoading: Boolean = false,
    val error: String = "",
    val jokeResponse: JokeResponse? = null
)
