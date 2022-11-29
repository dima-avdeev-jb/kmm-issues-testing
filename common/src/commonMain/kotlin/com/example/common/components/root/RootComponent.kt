package com.example.common.components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.example.common.components.authorization.AuthorizationComponent
import com.example.common.components.main.MainComponent
import kotlinx.coroutines.Dispatchers
import org.koin.core.component.KoinComponent

class RootComponent(
  componentContext: ComponentContext,
  private val storeFactory: StoreFactory
) : Root, KoinComponent, ComponentContext by componentContext {
  private val navigation = StackNavigation<Config>()

  private val stack = childStack(
    source = navigation,
    initialConfiguration = Config.Main,
    handleBackButton = true,
    childFactory = ::createChild
  )

  override val childStack: Value<ChildStack<*, Root.Child>>
    get() = stack

  private fun createChild(
    config: Config,
    componentContext: ComponentContext
  ): Root.Child = when (config) {
    is Config.Main -> Root.Child.A(component = MainComponent(
      componentContext = componentContext,
      onOpenAuthorizationPage = {
        openAuthorizationPage()
      }
    ))

    is Config.Authorization -> Root.Child.B(
      component = AuthorizationComponent(
        componentContext = componentContext,
        storeFactory = storeFactory,
        mainContext = Dispatchers.Main,
        onAuthorized = {
          openMainPage()
        }
      )
    )
  }

  override fun openAuthorizationPage() {
    navigation.replaceCurrent(Config.Authorization)
  }

  override fun openMainPage() {
    navigation.replaceCurrent(Config.Main)
  }

  private sealed class Config : Parcelable {
    @Parcelize
    object Authorization : Config()

    @Parcelize
    object Main : Config()
  }
}