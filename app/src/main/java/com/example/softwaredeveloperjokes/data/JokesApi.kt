package com.example.softwaredeveloperjokes.data

import com.example.softwaredeveloperjokes.model.JokeResponse
import com.example.softwaredeveloperjokes.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesApi {
    @GET("/joke/Programming")
    suspend fun getJokes(
        @Query("amount") amount: Int = Constants.DEFAULT_AMOUNT
    ) : JokeResponse

}