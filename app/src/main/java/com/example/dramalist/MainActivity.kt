package com.example.dramalist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dramalist.ui.theme.DramaListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DramaListTheme(dynamicColor = false) {
                DramaListApp()
            }
        }
    }
}