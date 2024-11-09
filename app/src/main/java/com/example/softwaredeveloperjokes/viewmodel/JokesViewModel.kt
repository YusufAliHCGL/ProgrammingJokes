package com.example.softwaredeveloperjokes.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.softwaredeveloperjokes.data.JokesApi
import com.example.softwaredeveloperjokes.util.Constants
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit

class JokesViewModel(application: Application) : AndroidViewModel(application) {

    private val client = OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build()

    private val jokesApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build().create(JokesApi::class.java)

    private val _jokesState: MutableState<JokeState> = mutableStateOf(JokeState())
    val jokesState: State<JokeState> = _jokesState

    init {
        getJokesFromApi(Constants.DEFAULT_AMOUNT)
    }

    fun getJokesFromApi(amount: Int) {
        viewModelScope.launch {
            _jokesState.value = jokesState.value.copy(
                isLoading = true,
                error = ""
            )
            try {
                val jokeResponse = jokesApi.getJokes(amount = amount)
                _jokesState.value = this@JokesViewModel.jokesState.value.copy(
                    isLoading = false,
                    error = "",
                    jokeResponse = jokeResponse
                )
            } catch (e: SocketTimeoutException) {
                _jokesState.value = jokesState.value.copy(
                    isLoading = false,
                    error = "Timeout Exception",
                    jokeResponse = null
                )
            } catch (e: Exception) {
                _jokesState.value = jokesState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Unexpected Error",
                    jokeResponse = null
                )
            }

        }
    }


}