package com.example.weathercompose.compose

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weathercompose.data.getResult

@Composable
fun Greeting(name: String, context: Context){
    val state = remember{
        mutableStateOf("Unknown")
    }
    Column(modifier = Modifier
        .fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
            ){
            Text(text = "Temperatura in $name = ${state.value} C")
        }
        Box(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ){
            Button(onClick = {
                             getResult(name,state, context)
            }, modifier = Modifier.padding(5.dp)
                .fillMaxWidth()
            ) {
                Text(text = "Refresh")

            }
        }
        
    }
    
}