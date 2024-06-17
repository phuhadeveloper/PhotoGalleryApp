package com.example.photogalleryapp

/*
* author: Phu Ha
* date: June 16, 2024
*
* This file contain the MainActivity class.
*
* The Scaffold composable is the root
* There is a top app parameter in the Scaffold composable
*
* */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.photogalleryapp.ui.PhotoGalleryApp
import com.example.photogalleryapp.ui.theme.PhotoGalleryAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhotoGalleryAppTheme {
                Scaffold(
                    topBar = { CenterAlignedTopAppBar(title = { Text(text = "Photo Gallery") }) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    PhotoGalleryApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

