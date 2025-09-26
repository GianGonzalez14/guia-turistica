package com.example.myapplication.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BuscarDestinoTuristico() {
    // Estado del campo de búsqueda
    var searchQuery by remember { mutableStateOf("") }

    // Lista de destinos de ejemplo (se podrá cargar dinámicamente luego)
    val destinos = listOf(
        "Cartagena de Indias",
        "San Andrés Islas",
        "Bogotá – Monserrate",
        "Medellín – Comuna 13",
        "Cali – Cristo Rey",
        "Santa Marta – Tayrona",
        "Villa de Leyva"
    )

    // Filtrar destinos según búsqueda
    val destinosFiltrados = destinos.filter {
        it.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Buscar Destino Turístico",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campo de búsqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar destino...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Lista de destinos filtrados
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(destinosFiltrados) { destino ->
                DestinoItem(destino)
            }
        }
    }
}

@Composable
fun DestinoItem(nombre: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                // Aquí pondrás la acción al hacer clic en un destino
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = nombre,
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BuscarDestinoTuristicoPreview() {
    BuscarDestinoTuristico()
}
