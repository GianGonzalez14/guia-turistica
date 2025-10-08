package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.items.VerFotosScreen
import com.example.myapplication.items.VerMapaScreen
import com.example.myapplication.items.VerVideoScreen
import com.example.myapplication.items.BuscarDestinoTuristico
import com.example.myapplication.items.ContactarSoporteScreen
import com.example.myapplication.items.EnlacesWebScreen
import com.example.myapplication.items.InterfazDeInicio
import com.example.myapplication.items.VerPerfil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "inicio"
            ) {
                composable("inicio") { InterfazDeInicio(navController) }
                composable("ver_fotos") { VerFotosScreen() }
                composable("ver_perfil") { VerPerfil() }
                composable("ver_videos") { VerVideoScreen() }
                composable("buscar_destino") { BuscarDestinoTuristico() }
                composable("enlaces_web") { EnlacesWebScreen() }
                composable("mapa_ubicacion") { VerMapaScreen() }
                composable("contactar_soporte") { ContactarSoporteScreen() }

            }
        }
    }
}
