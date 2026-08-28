package com.tongchangya.abhiraza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tongchangya.abhiraza.ui.theme.AbhirazaTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      AbhirazaTheme {
        MainScreen()
      }
    }
  }
}
