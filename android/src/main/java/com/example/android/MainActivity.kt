package com.example.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.router.stack.replaceCurrent

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val root = RootComponent(
      componentContext = defaultComponentContext()
    )
    setContent {
      App(root.childStack) {
        navigation.replaceCurrent(Config.B)
      }
    }
  }
}
