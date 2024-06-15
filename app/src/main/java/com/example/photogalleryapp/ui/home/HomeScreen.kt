package com.example.photogalleryapp.ui.home

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.photogalleryapp.ui.PhotoGalleryApp
import com.example.photogalleryapp.ui.theme.PhotoGalleryAppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember { mutableStateOf("") }

        val scrollState = rememberLazyGridState()
        val coroutineScope = rememberCoroutineScope()

        val listOfURLs = remember { mutableStateListOf<String>() }

        val onclickButton = {
            listOfURLs.add(text)
            text = ""
        }

        TextField(
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {text = it},
            label = { Text("URL") }
        )

        Button(
            onClick = onclickButton
        ) {
            Text("Load")
        }
        LazyVerticalGrid(
            columns =  GridCells.Adaptive(minSize = 150.dp),
            content = {
                items(
                    items = listOfURLs,
                    key = { url: String -> url }
                ) {url ->
                    PhotoCard(url = url)
                }
            }
        )
    }
}

@Composable
fun PhotoCard(
    url: String,
    modifier: Modifier = Modifier
    ) {
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
    )

}

@Preview
@Composable
fun HomeScreenPreview() {
    PhotoGalleryAppTheme {
        HomeScreen()
    }
}