package com.example.photogalleryapp.ui.home

/*
* author: Phu Ha
* date: June 16, 2024
*
* This file contains the main composable of the home screen. There are three main
* components of the home screen: The input text field, the load button, and the lazy
* vertical grid that displays the photos
*
* */

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.photogalleryapp.R
import com.example.photogalleryapp.ui.PhotoGalleryApp
import com.example.photogalleryapp.ui.theme.PhotoGalleryAppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // to save user's input
        var text by remember { mutableStateOf("") }
        // keep track of the current id for the next photo
        var id by remember { mutableIntStateOf(0) }

        // list that stores all the urls
        val listOfPhotos = remember { mutableStateListOf<Photo>() }

        // store onclick function for button
        val onclickButton = {
            // add a new Photo object
            listOfPhotos.add(Photo(url = text, id = id))
            // increment id
            id++
            // reset text
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
            contentPadding = contentPadding
        ) {
            items(
                items = listOfPhotos,
                key = { photo: Photo -> photo.id }
            ) {photo ->
                PhotoCard(
                    url = photo.url
                )
            }
        }
    }
}

@Composable
fun PhotoCard(
    url: String,
    modifier: Modifier = Modifier
    ) {

    Card(
        modifier = modifier.aspectRatio(1.0f),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(url)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxWidth()
        )
    }

}

// Photo class to store url and id
class Photo(
    id: Int,
    url: String
) {
    val id: Int = id
        get() = field
    val url = url
        get() = field
}

@Preview
@Composable
fun HomeScreenPreview() {
    PhotoGalleryAppTheme {
        HomeScreen()
    }
}