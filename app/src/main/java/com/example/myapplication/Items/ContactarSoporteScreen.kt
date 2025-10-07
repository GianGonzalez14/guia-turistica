package com.example.myapplication.items

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactarSoporteScreen() {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contactar Soporte") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "¿Necesitas ayuda?",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Puedes contactarte con nuestro equipo de soporte a través de los siguientes medios:",
                style = MaterialTheme.typography.bodyMedium
            )

            // Botón WhatsApp
            Button(
                onClick = {
                    val uri = Uri.parse("https://wa.me/573001234567")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    try {
                        context.startActivity(intent)
                    } catch (e: Exception) {
                        // fallback por si no hay WhatsApp
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/573001234567"))
                        context.startActivity(browserIntent)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Enviar mensaje por WhatsApp", fontSize = 16.sp)
            }

            // Botón correo
            Button(
                onClick = {
                    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:soporte@guiaturistica.com")
                        putExtra(Intent.EXTRA_SUBJECT, "Consulta desde la app")
                    }
                    try {
                        context.startActivity(emailIntent)
                    } catch (e: Exception) {
                        // fallback
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:soporte@guiaturistica.com"))
                        context.startActivity(browserIntent)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7))
            ) {
                Text("Enviar correo electrónico", fontSize = 16.sp)
            }

            // Botón llamada telefónica
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:+573001234567")
                    }
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688))
            ) {
                Text("Llamar al soporte técnico", fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContactarSoporteScreen() {
    ContactarSoporteScreen()
}
