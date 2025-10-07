package com.example.myapplication.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R

@Composable
fun VerPerfil() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen de perfil
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // remplazar por avatar real
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre de usuario
        Text(
            text = "Nombre del Usuario",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Correo
        Text(
            text = "usuario@email.com",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Información adicional
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Teléfono: +57 300 123 4567")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Nacionalidad: Colombiana")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Preferencias: Playas, Cultura, Aventura")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón de acción
        Button(
            onClick = { /* Acción futura: Editar perfil */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Editar Perfil")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerPerfilPreview() {
    VerPerfil()
}
