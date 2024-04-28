package com.devrachit.customkeyboard2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devrachit.customkeyboard2.ui.theme.CustomKeyboard2Theme
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomKeyboardApp()
        }
    }

}
fun isKeyboardEnabled(context: Context): Boolean {
    val sharedPreferences = context.getSharedPreferences("keyboard_prefs", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean("custom_keyboard_enabled", false)
}
fun openKeyboardSettings(context: Context) {
    val intent = Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)
    context.startActivity(intent)
}

fun openKeyboardChooserSettings(context: Context) {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showInputMethodPicker()
}
@ExperimentalMaterial3Api
@Composable
fun CustomKeyboardApp() {
    val context = LocalContext.current
    var keyboardEnabled by remember { mutableStateOf(isKeyboardEnabled(context)) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Custom Keyboard") }
            )
        },
        content = {
            Log.d("",it.toString())
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Custom Keyboard Prototype", modifier = Modifier.padding(16.dp))
                Button(
                    onClick = {
                        if (!keyboardEnabled) {
                            openKeyboardSettings(context)
                        }
                    },
                    enabled = !keyboardEnabled
                ) {
                    Text(text = "Enable Keyboard")
                }
                Button(
                    onClick = { openKeyboardChooserSettings(context) },
                    enabled = keyboardEnabled
                ) {
                    Text(text = "Choose Keyboard")
                }
            }
        }
    )
}
