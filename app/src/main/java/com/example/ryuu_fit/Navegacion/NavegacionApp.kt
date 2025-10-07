package com.example.ryuu_fit.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ryuu_fit.Navegacion.AppPantallas
import com.example.ryuu_fit.pantallas.HomeScreen
import com.example.ryuu_fit.pantallas.LoginScreen
import com.example.ryuu_fit.pantallas.TestInicialScreen
import com.example.ryuu_fit.pantallas.detallesEjercicio
import com.example.ryuu_fit.pantallas.detallesTraining
import com.example.ryuu_fit.pantallas.trainingWeek

@Composable
fun NavegacionApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppPantallas.Login.ruta
    )
    {
        composable(route = AppPantallas.Login.ruta) {
            LoginScreen(navController)
        }
        composable(route = AppPantallas.Home.ruta) {
            HomeScreen(navController)
        }
        composable(route = AppPantallas.Test.ruta) {
            TestInicialScreen(navController)
        }
        composable(route = AppPantallas.DetallesTr.ruta) {
            detallesTraining(navController)
        }
        composable(route = AppPantallas.DetallesEx.ruta) {
            detallesEjercicio(navController)
        }
        composable(route = AppPantallas.TrainingWeek.ruta) {
            trainingWeek(navController)
        }

    }

}