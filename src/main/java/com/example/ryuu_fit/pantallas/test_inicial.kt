package com.example.ryuu_fit.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ryuu_fit.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestInicialScreen(navController: NavController) {
    var parte by remember { mutableStateOf(1) } // estado: parte 1 o parte 2

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Test Inicial", color = Color.White, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: volver atrás */ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_google), // cambia por tu ícono real
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black
                )
            )
        },
        containerColor = Color.Black,
        bottomBar = {
            Button(
                onClick = {
                    if (parte == 1) parte = 2 else {/* TODO: finalizar */}
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = if (parte == 1) "Siguiente" else "Terminar",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.Black)
                .padding(16.dp)
        ) {
            if (parte == 1) {
                DropdownField("Edad")
                DropdownField("Altura (Cm)")
                DropdownField("Peso (Kg)")
                DropdownField("Género")
                DropdownField("Complexión corporal")
                DropdownField("Frecuencia de actividad física")
                DropdownField("Nivel de condición física")
                DropdownField("Objetivo principal")
                DropdownField("Qué tiempo diario entrenarías")
                DropdownField("Cuántos días a la semana entrenarías")
                DropdownField("Tienes restricciones alimenticias")
                DropdownField("Frecuencia consumo de comidas rápidas")
            } else {
                DropdownField("Cuántas horas sueles dormir")
                DropdownField("Qué te motiva a entrenar")
                DropdownField("Peso (Kg)")
                DropdownField("Quieres recibir notificaciones")

                Spacer(modifier = Modifier.height(24.dp))

                Image(
                    painter = painterResource(id = R.drawable.ryuu_fit_image),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "RYUU-FIT",
                    color = Color.Red,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownField(label: String) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("seleccione el rango") }
    val options = listOf("Opción 1", "Opción 2", "Opción 3")

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            label = { Text(label, color = Color.White) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                disabledTextColor = Color.Gray,
                focusedContainerColor = Color.Black,
                unfocusedContainerColor = Color.Black,
                disabledContainerColor = Color.Black,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Gray,
                disabledIndicatorColor = Color.DarkGray
            ),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedText = option
                        expanded = false
                    }
                )
            }
        }
    }
}



