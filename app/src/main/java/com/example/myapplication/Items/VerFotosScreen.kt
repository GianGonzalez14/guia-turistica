package com.example.myapplication.items

import androidx.compose.foundation.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import androidx.compose.ui.window.Dialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerFotosScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Galería de Fotos") }
            )
        }
    ) { padding ->
        FotoList(
            modifier = Modifier.padding(padding)
        )
    }
}
    // Lista de imagenes, las guarde en la carpeta res/drawable
@Composable
fun FotoList(modifier: Modifier = Modifier) {
    val fotos: List<Int> = listOf(
        R.drawable.foto1,
        R.drawable.foto2,
        R.drawable.foto3,
        R.drawable.foto4,
        R.drawable.foto5,
        R.drawable.foto6
    )

    // Estado para la foto seleccionada
    var fotoSeleccionada by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ) {
        fotos.forEach { foto ->
            Image(
                painter = painterResource(id = foto),
                contentDescription = "Foto",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 16.dp)
                    .clickable { fotoSeleccionada = foto }, // click para abrir
                contentScale = ContentScale.Crop
            )
        }
    }

    // Dialog para mostrar la foto ampliada, aun le falta hacer zoom a la imagen
    if (fotoSeleccionada != null) {
        Dialog(onDismissRequest = { fotoSeleccionada = null }) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 8.dp
            ) {
                Image(
                    painter = painterResource(id = fotoSeleccionada!!),
                    contentDescription = "Foto ampliada",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

//pendiente que descripciones de imagenes si se decide colocar


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VerFotosScreenPreview() {
    VerFotosScreen()
}