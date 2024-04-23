package com.devrachit.customkeyboard2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.devrachit.customkeyboard2.ui.theme.CustomKeyboard2Theme
import com.example.keyboardapp.ui.screens.TestScreen

class TestActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomKeyboard2Theme {
                TestScreen()
            }
        }
    }
}