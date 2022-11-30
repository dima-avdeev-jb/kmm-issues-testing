package com.example.common.components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.example.common.components.main.Main
import org.koin.core.component.KoinComponent

class RootComponent(
  componentContext: ComponentContext
) : Root, KoinComponent, ComponentContext by componentContext {
  private val navigation = StackNavigation<Config>()

  private val stack = childStack(
    source = navigation,
    initialConfiguration = Config.A,
    handleBackButton = true,
    childFactory = ::createChild
  )

  override val childStack: Value<ChildStack<*, Root.Child>>
    get() = stack

  private fun createChild(
    config: Config,
    componentContext: ComponentContext
  ): Root.Child = when (config) {
    is Config.A -> Root.Child.A(
      object : Main, ComponentContext by componentContext {
        override fun openB() {
          openBPage()
        }
      }
    )
    is Config.B -> Root.Child.B()
  }

  override fun openBPage() {
    navigation.replaceCurrent(Config.B)
  }

  override fun openAPage() {
    navigation.replaceCurrent(Config.A)
  }

  private sealed class Config : Parcelable {
    @Parcelize
    object B : Config()

    @Parcelize
    object A : Config()
  }
}
