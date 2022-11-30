package com.example.android

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import kotlinx.parcelize.Parcelize

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

class RootComponent(
  componentContext: ComponentContext
) : Root, ComponentContext by componentContext {
  override val childStack: Value<ChildStack<*, Root.Child>> = childStack(
    source = navigation,
    initialConfiguration = Config.A,
    childFactory = { config: Config, _ ->
      when (config) {
        is Config.A -> Root.Child.A()
        is Config.B -> Root.Child.B()
      }
    }
  )
}

val navigation = StackNavigation<Config>()

sealed class Config : Parcelable {
  @Parcelize
  object B : Config()
  @Parcelize
  object A : Config()
}
