package com.example.myapplication.items

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapplication.R

@Composable
fun VerVideoScreen() {
    val context = LocalContext.current

    // Lista de videos con su portada asociada
    val videos = listOf(
        VideoItem("video1", R.drawable.portada_video1),
        VideoItem("video2", R.drawable.portada_video2),
        VideoItem("video3", R.drawable.portada_video3)
    )

    var videoSeleccionado by remember { mutableStateOf<VideoItem?>(null) }

    if (videoSeleccionado == null) {
        // Vista de galería
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(videos) { video ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clickable { videoSeleccionado = video },
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = video.portadaRes),
                            contentDescription = video.nombre,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = video.nombre,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    } else {
        // Pantalla de reproducción
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AndroidView(
                factory = {
                    VideoView(it).apply {
                        val uri = Uri.parse("android.resource://${context.packageName}/raw/${videoSeleccionado!!.nombre}")
                        setVideoURI(uri)
                        val mediaController = MediaController(context)
                        mediaController.setAnchorView(this)
                        setMediaController(mediaController)
                        start()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { videoSeleccionado = null }) {
                Text("Volver a galería")
            }
        }
    }
}

// Modelo de datos
data class VideoItem(
    val nombre: String,
    val portadaRes: Int
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VerVideosScreenPreview() {
    VerVideoScreen()
}