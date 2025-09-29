package com.example.ryuu_fit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
//import com.example.ryuu_fit.Navegacion.NavegacionApp
import com.example.ryuu_fit.ui.theme.RYUU_FITTheme
import com.example.ryuu_fit.pantallas.LoginScreen
import com.example.ryuu_fit.pantallas.TestInicialScreen
import com.example.ryuu_fit.pantallas.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RYUU_FITTheme {
                //NavegacionApp()
                LoginScreen()

            }
        }
    }
}

/*-
@Composable

fun AppNavigation() {
    // Estado que define en qué pantalla estamos
    var currentScreen by remember { mutableStateOf("login") }

    when (currentScreen) {
        "login" -> LoginScreen(
            onLoginSuccess = { currentScreen = "home" },
            onRegisterClick = { currentScreen = "test" }
        )
        "home" -> HomeScreen(
            onLogoutClick = { currentScreen = "login" }
        )
        "test" -> TestInicialScreen(
            onTestFinish = { currentScreen = "home" }
        )
    }
}
*/
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    RYUU_FITTheme {
        //NavegacionApp()
        LoginScreen()
    }
}
