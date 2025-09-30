package com.example.ryuu_fit.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ryuu_fit.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    onNavigate: () -> Unit = {} // callback para ir a la Parte 3
) {
    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google), // ic_home
                            contentDescription = "Home",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Inicio") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google), //ic_rutinas
                            contentDescription = "Rutinas",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Rutinas") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),//ic_notificaciones
                            contentDescription = "Notificaciones",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Alertas") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google), //ic_perfil
                            contentDescription = "Perfil",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Perfil") }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Barra de búsqueda
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Buscar", color = Color.Gray) },
                leadingIcon = {
                    Image(
                        painter = painterResource(R.drawable.ryuu_fit_image),
                        contentDescription = "Buscar",
                        modifier = Modifier.size(24.dp)
                    )
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Chips
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FilterChip("Avances", onClick = onNavigate)
                FilterChip("Rutinas")
                FilterChip("Nutrición")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Logo
            Image(
                painter = painterResource(id = R.drawable.ryuu_fit_image),
                contentDescription = "Logo",
                modifier = Modifier.size(180.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Fila de categorías
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CategoryIcon(R.drawable.ic_google, "Cardio")
                CategoryIcon(R.drawable.ic_google, "Fuerza")
                CategoryIcon(R.drawable.ic_google, "Resistencia")
                CategoryIcon(R.drawable.ic_google, "Elasticidad")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Opciones con imágenes
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OptionCard(R.drawable.ic_google, "Actualización de información")
                OptionCard(R.drawable.ic_google, "Opciones de dietas")
            }
        }
    }
}

@Composable
fun FilterChip(text: String, onClick: () -> Unit = {}) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color.DarkGray,
        modifier = Modifier.clickable { onClick() }
    ) {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            fontSize = 14.sp
        )
    }
}

@Composable
fun CategoryIcon(iconRes: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            modifier = Modifier.size(64.dp),
            shape = CircleShape,
            color = Color.Transparent,
            tonalElevation = 2.dp
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, color = Color.White, fontSize = 12.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun OptionCard(imageRes: Int, text: String) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .background(Color.DarkGray, RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
}


