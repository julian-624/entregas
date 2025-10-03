package com.example.ryuu_fit.pantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ryuu_fit.R

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuScreen(
                onRutinaClick = {
                    // Navegar a RutinaActivity
                    startActivity(android.content.Intent(this, RutinaActivity::class.java))
                },
                onPlanClick = {
                    // Navegar a PlanAlimenticioActivity
                    startActivity(android.content.Intent(this, RutinaActivity::class.java))
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    onRutinaClick: () -> Unit,
    onPlanClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo de la app
            Image(
                painter = painterResource(id = R.drawable.ryuu_fit_image),
                contentDescription = "Logo Ryuu Fit",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 16.dp)
            )

            // Mensaje de bienvenida
            Text(
                text = "¡Bienvenido ahora vamos a cambiar tu vida!",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Datos del usuario
            UserDataCard("Peso Actual - 54 Kg   Peso Deseado 63 Kg")
            Spacer(modifier = Modifier.height(8.dp))

            UserDataCard("Días semanales para ejercitarse: L M M J V S")
            Spacer(modifier = Modifier.height(8.dp))

            UserDataCard("Horas diarias para realizar ejercicio: 2-3")
            Spacer(modifier = Modifier.height(32.dp))

            // Botón Rutina semanal con imagen
            Card(
                onClick = onRutinaClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    // Imagen de fondo para Rutina semanal
                    Image(
                        painter = painterResource(id = R.drawable.ejercicio_casa),
                        contentDescription = "Rutina semanal",
                        modifier = Modifier.fillMaxSize()
                    )
                    Text(
                        text = "Rutina Semanal",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black.copy(alpha = 0.7f))
                            .padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón Plan alimenticio con imagen
            Card(
                onClick = onPlanClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF333333))
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    // Imagen de fondo para Plan alimenticio
                    Image(
                        painter = painterResource(id = R.drawable.alimentacion_balanceada),
                        contentDescription = "Plan alimenticio",
                        modifier = Modifier.fillMaxSize()
                    )
                    Text(
                        text = "Plan Alimenticio",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black.copy(alpha = 0.7f))
                            .padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun UserDataCard(text: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF333333))
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(
        onRutinaClick = { },
        onPlanClick = { }
    )
}