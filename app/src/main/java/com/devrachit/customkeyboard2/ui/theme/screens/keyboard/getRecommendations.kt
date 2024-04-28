package com.devrachit.customkeyboard2.ui.theme.screens.keyboard

import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.inputmethodservice.InputMethodService
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.devrachit.customkeyboard2.BuildConfig
//import com.devrachit.customkeyboard2.suggestion1
//import com.devrachit.customkeyboard2.suggestion2
//import com.devrachit.customkeyboard2.suggestion3
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

private var recommendationJob: Job? = null
var suggestion1 by mutableStateOf("")
var suggestion2 by mutableStateOf("")
var suggestion3 by mutableStateOf("")
fun getRecommendations(text: String) {
    val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = BuildConfig.api_key
    )
    recommendationJob?.cancel() // Cancel the previous job if exists
    recommendationJob = CoroutineScope(Dispatchers.IO).launch {
        try {
            val prompt =
                "Give me three different suggestion each separated by a space only no other formatting and containing maximum 1 words not more than that which i might say after : ${text}"
            val response = generativeModel.generateContent(prompt)
            val words = response.text.toString().split(" ")
            suggestion1 = words[0]
            suggestion2 = words[1]
            suggestion3 = words[2]
            println(words[0])
            println(suggestion1)
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }
}