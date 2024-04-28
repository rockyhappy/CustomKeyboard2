package com.devrachit.customkeyboard2.ui.screens.keyboard

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AbstractComposeView
import androidx.core.graphics.toColorInt
import com.devrachit.customkeyboard2.ui.theme.screens.keyboard.KeyboardScreen2

class ComposeKeyboardView(context: Context): AbstractComposeView(context) {
    @Composable
    override fun Content() {
        val pre = context.getSharedPreferences("keyboard_color", Context.MODE_PRIVATE)
        val background = pre.getString("background", "White")
        val key = pre.getString("key", "White")
        val text = pre.getString("text", "Black")
        val backgroundColor = background?.toString()?.toColorInt()?.let { Color(it) } ?: Color.Transparent
        val keyColor = key?.toString()?.toColorInt()?.let { Color(it) } ?: Color.Black
        val textColor = text?.toString()?.toColorInt()?.let { Color(it) } ?: Color.White
        KeyboardScreen2()
    }
}