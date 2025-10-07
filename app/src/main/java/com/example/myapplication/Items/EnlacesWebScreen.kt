package com.example.myapplication.items

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnlacesWebScreen() {
    val context = LocalContext.current

    val enlaces = listOf(
        "https://colombia.travel/es" to "Turismo en Colombia - Sitio Oficial",
        "https://www.lonelyplanet.com/south-america/colombia" to "Guía Lonely Planet - Colombia",
        "https://www.tripadvisor.com/Tourism-g294073-Colombia-Vacations.html" to "TripAdvisor - Colombia",
        "https://es.wikipedia.org/wiki/Colombia" to "Wikipedia - Historia y Cultura de Colombia",
        "https://www.eltiempo.com/turismo" to "El Tiempo - Sección de Turismo"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Enlaces Turísticos") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(enlaces) { (url, descripcion) ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                // fallback en caso de error
                                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                context.startActivity(browserIntent)
                            }
                        },
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = descripcion,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text = url,
                            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEnlacesWebScreen() {
    EnlacesWebScreen()
}
