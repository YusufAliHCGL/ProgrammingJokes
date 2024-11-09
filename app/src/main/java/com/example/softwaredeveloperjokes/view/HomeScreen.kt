package com.example.softwaredeveloperjokes.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwaredeveloperjokes.util.Constants
import com.example.softwaredeveloperjokes.viewmodel.JokesViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    viewModel: JokesViewModel
) {

    val jokeState by viewModel.jokesState
    Surface(color = MaterialTheme.colorScheme.surface) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (jokeState.isLoading) {
                CircularProgressIndicator(
                    color = Color.White,
                    trackColor = Color.Black
                )
            } else {
                if (jokeState.error.isNotBlank() || jokeState.jokeResponse?.error == true) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = jokeState.error,
                            fontSize = 28.sp,
                            color = Color.Red
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { viewModel.getJokesFromApi(Constants.DEFAULT_AMOUNT) },
                            shape = RoundedCornerShape(16.dp),
                        ) {
                            Text(
                                text = "Retry",
                                fontSize = 22.sp
                            )
                        }
                    }
                } else if(jokeState.jokeResponse != null) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(onClick = { viewModel.getJokesFromApi(Constants.DEFAULT_AMOUNT) }) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Refresh Jokes",
                                modifier = Modifier.scale(1.5f)
                            )
                        }
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(jokeState.jokeResponse!!.jokes) { joke ->
                                JokeItem(
                                    joke = joke,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }


}