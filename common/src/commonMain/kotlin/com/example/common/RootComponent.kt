package com.example.common

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import org.koin.core.component.KoinComponent

class RootComponent(
  componentContext: ComponentContext
) : Root, KoinComponent, ComponentContext by componentContext {

  private val stack = childStack(
    source = navigation,
    initialConfiguration = Config.A,
    childFactory = ::createChild
  )

  override val childStack: Value<ChildStack<*, Root.Child>> = stack

  private fun createChild(config: Config, componentContext: ComponentContext): Root.Child = when (config) {
    is Config.A -> Root.Child.A()
    is Config.B -> Root.Child.B()
  }

}

val navigation = StackNavigation<Config>()
sealed class Config : Parcelable {
  @Parcelize
  object B : Config()
  @Parcelize
  object A : Config()
}