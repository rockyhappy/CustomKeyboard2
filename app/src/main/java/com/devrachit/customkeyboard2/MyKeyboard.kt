package com.devrachit.customkeyboard2

// MyKeyboard.kt

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomKeyboard(
    onKeyPress: (String) -> Unit,
    onBackspacePress: () -> Unit,
    onEnterPress: () -> Unit,
    onSpacePress: () -> Unit
) {
    Column {
        // Define your keyboard buttons here
        // Example: Row with buttons for each key
        for (row in keyboardLayout) {
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                for (key in row) {
                    Button(onClick = { onKeyPress(key) }) {
                        Text(text = key)
                    }
                }
            }
        }

        // Special buttons
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Button(onClick = { onBackspacePress() }) {
                Text(text = "Backspace")
            }
            Button(onClick = { onEnterPress() }) {
                Text(text = "Enter")
            }
            Button(onClick = { onSpacePress() }) {
                Text(text = "Space")
            }
        }
    }
}

// Define your custom keyboard layout here
val keyboardLayout = listOf(
    listOf("1", "2", "3"),
    listOf("4", "5", "6"),
    listOf("7", "8", "9"),
    listOf(".", "0", ",")
    // Add more rows as needed
)
