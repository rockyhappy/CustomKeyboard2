package com.devrachit.customkeyboard2.ui.theme.screens.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
//import com.devrachit.customkeyboard2.suggestion1
//import com.devrachit.customkeyboard2.suggestion2
//import com.devrachit.customkeyboard2.suggestion3

@Composable
fun KeyboardScreen2 ()
{

    Column (
        modifier= Modifier
            .fillMaxWidth()
            .background(Color.Black),
    )
    {
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Suggestions(suggestion1)
            Suggestions(suggestion2)
            Suggestions(suggestion3)
        }

        Row(
            modifier= Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            SingleKey("1")
            SingleKey("2")
            SingleKey("3")
            SingleKey("4")
            SingleKey("5")
            SingleKey("6")
            SingleKey("7")
            SingleKey("8")
            SingleKey("9")
            SingleKey("0")
        }
        Row(
            modifier= Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            SingleKey("q")
            SingleKey("w")
            SingleKey("e")
            SingleKey("r")
            SingleKey("t")
            SingleKey("y")
            SingleKey("u")
            SingleKey("i")
            SingleKey("o")
            SingleKey("p")
        }
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            SingleKey("a")
            SingleKey("s")
            SingleKey("d")
            SingleKey("f")
            SingleKey("g")
            SingleKey("h")
            SingleKey("j")
            SingleKey("k")
            SingleKey("l")
        }
        Row(
            modifier= Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        )
        {
//            SingleKey("Shift")
            SingleKey("z")
            SingleKey("x")
            SingleKey("c")
            SingleKey("v")
            SingleKey("b")
            SingleKey("n")
            SingleKey("m")
            SingleKey("⇐")
        }
        Row(
            modifier= Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            SingleKey(",")
            SingleKey(" ")
            SingleKey(".")
            SingleKey("↩")
        }
    }
}