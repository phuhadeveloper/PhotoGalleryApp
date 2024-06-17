package com.example.photogalleryapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.photogalleryapp.ui.home.HomeScreen
import com.example.photogalleryapp.ui.theme.PhotoGalleryAppTheme

@Composable
fun PhotoGalleryApp(
    modifier: Modifier = Modifier
) {
    HomeScreen(
        modifier = modifier.fillMaxSize()
    )
}

@Preview
@Composable
fun PhotoGalleryAppPreview() {
    PhotoGalleryAppTheme {
        PhotoGalleryApp()
    }
}