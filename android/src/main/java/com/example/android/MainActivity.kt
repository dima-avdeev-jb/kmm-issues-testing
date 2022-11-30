package com.example.android

import com.example.common.App
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import com.arkivanov.decompose.defaultComponentContext
import com.example.common.RootComponent

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val root = RootComponent(
      componentContext = defaultComponentContext()
    )

    setContent {
      MaterialTheme {
        App(root)
      }
    }
  }
}