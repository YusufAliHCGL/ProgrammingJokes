package com.example.softwaredeveloperjokes.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.softwaredeveloperjokes.model.Joke

@Composable
fun JokeItem(
    modifier: Modifier = Modifier,
    joke: Joke
) {

    ElevatedCard(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            if (joke.type == "single") {
                Text(
                    text = joke.joke ?: "",
                )
            } else if (joke.type == "twopart") {
                Text(
                    text = joke.setup ?: "",
                )
                Spacer(modifier = Modifier.height(9.dp))
                Text(
                    text = joke.delivery ?: "",
                )
            }
        }
    }

}