package com.devrachit.customkeyboard2.ui.theme.screens.keyboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import android.view.KeyEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devrachit.customkeyboard2.KeyboardService

@Composable
fun SingleKey(key: String) {

    val interactionSource = remember { MutableInteractionSource() }
    val ctx = LocalContext.current
    val onClick: () -> Unit = {
        if (key == "↩")
            (ctx as KeyboardService).currentInputConnection.sendKeyEvent(
                KeyEvent(
                    KeyEvent.ACTION_DOWN,
                    KeyEvent.KEYCODE_ENTER
                )
            )
        else if (key == "⇐")
            (ctx as KeyboardService).currentInputConnection.sendKeyEvent(
                KeyEvent(
                    KeyEvent.ACTION_DOWN,
                    KeyEvent.KEYCODE_DEL
                )
            )
        else
            (ctx as KeyboardService).currentInputConnection.commitText(
                key,
                key.length
            )
        if(key==" ") {
            val text = (ctx as KeyboardService).currentInputConnection.getTextBeforeCursor(100, 0)
                ?.toString()?.trim()
            if (text != null) {
                getRecommendations(text)
            }
        }
    }


    Text(
        text = if(key==" ")"______"  else key,
        fontSize = 20.sp,
        color = Color.White,
        modifier = Modifier
            .background(Color.Transparent)
            .padding(top=5.dp, bottom=5.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onClick()},
    )

}