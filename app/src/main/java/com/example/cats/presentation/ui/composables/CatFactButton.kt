package com.example.cats.presentation.ui.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CatFactButton(onClick:()-> Unit){
        Button(onClick = onClick) {
            Text("Get a fact cat")
        }
}