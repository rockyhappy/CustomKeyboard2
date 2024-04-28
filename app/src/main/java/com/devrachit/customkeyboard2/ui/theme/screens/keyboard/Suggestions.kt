package com.devrachit.customkeyboard2.ui.theme.screens.keyboard

import android.view.KeyEvent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.devrachit.customkeyboard2.KeyboardService

@Composable
fun Suggestions(key: String ="Hello") {
    val interactionSource = remember { MutableInteractionSource() }
    val ctx = LocalContext.current
    Text(
        text = key,
        color = Color.White,
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            )
            {
                (ctx as KeyboardService).currentInputConnection.commitText(
                    key,
                    key.length
                )
            }
    )
}

