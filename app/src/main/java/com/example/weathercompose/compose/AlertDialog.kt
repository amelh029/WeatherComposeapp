package com.example.weathercompose.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun DialogSearh(dialogState: MutableState<Boolean>, onSubmit: (String)-> Unit) {
    val dialogText = remember{
        mutableStateOf("")
    }
    AlertDialog(
        onDismissRequest = {
            dialogState.value = false

        },
        confirmButton = {
            TextButton(onClick = {
                onSubmit(dialogText.value)
                dialogState.value = false
            }) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                dialogState.value = false
            }) {
                Text(text = "Cancel")

            }
        },
        title = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Enter City:")
                TextField(value = dialogText.value, onValueChange = {
                    dialogText.value = it
                })
            }
        }
    )
}