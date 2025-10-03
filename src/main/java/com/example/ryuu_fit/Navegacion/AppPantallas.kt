package com.example.ryuu_fit.Navegacion

sealed class AppPantallas(val ruta: String) {
    object Login : AppPantallas("login")
    object Home : AppPantallas("home")
    object Test : AppPantallas("test")

    object DetallesTr : AppPantallas("detallesTr")

    object DetallesEx : AppPantallas("detallesEx")

    object TrainingWeek : AppPantallas("trainingWeek")

}