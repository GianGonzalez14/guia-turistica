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
import androidx.navigation.NavController

@Composable
fun BotonMenu(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(texto)
    }
}

@Composable
fun InterfazDeInicio(navController: NavController) {
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

        BotonMenu("Buscar destino turístico") { navController.navigate("buscar_destino") }
        BotonMenu("Ver Fotos") { navController.navigate("ver_fotos") }
        BotonMenu("Ver Videos") { navController.navigate("ver_videos") }
        BotonMenu("Ver Perfil") { navController.navigate("ver_perfil") }
        BotonMenu("Acceder a enlaces Web") { navController.navigate("enlaces_web") }
        BotonMenu("Mapa de ubicación") { navController.navigate("mapa_ubicacion") }
        BotonMenu("Contactar Soporte") { navController.navigate("contactar_soporte") }
    }
}
