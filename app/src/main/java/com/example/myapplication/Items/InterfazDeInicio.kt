package com.example.myapplication.items

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InterfazDeInicio() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Guía Turística",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Lista de botones
        BotonMenu("Buscar destino turístico")
        BotonMenu("Ver Fotos")
        BotonMenu("Ver Videos")
        BotonMenu("Ver Perfil")
        BotonMenu("Acceder a enlaces Web")
        BotonMenu("Mapa de ubicación")
        BotonMenu("Contactar Soporte")
    }
}

@Composable
fun BotonMenu(texto: String) {
    Button(
        onClick = { /* Aquí pondrás la navegación futura */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(texto)
    }
}

@Preview(showBackground = true)
@Composable
fun InterfazDeInicioPreview() {
    InterfazDeInicio()
}
