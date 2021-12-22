package com.example.jetpackcompose_estado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose_estado.ui.theme.JetpackCompose_EstadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_EstadoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val (value,onValueChange) = rememberSaveable {mutableStateOf ("")} //remeberSaveable es para cuando rotamos
                    StateSample(
                        value =value,
                        onValueChange = onValueChange
                    )
                }
            }
        }
    }
}


@Composable
fun StateSample(value : String, onValueChange : (String)->Unit ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = value,
            onValueChange =  onValueChange,
            modifier = Modifier.fillMaxWidth()

        )
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
        )
        Button(
            onClick = { onValueChange("") },
            modifier = Modifier
                .fillMaxWidth(),
            enabled = value.isNotEmpty()
        ) {
            Text(
                text = "Clear"

            )

        }
    }
}