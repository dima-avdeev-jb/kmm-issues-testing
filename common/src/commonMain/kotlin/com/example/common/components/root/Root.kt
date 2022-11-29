package com.example.common.components.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.common.components.authorization.Authorization
import com.example.common.components.main.Main


interface Root {
  val childStack: Value<ChildStack<*, Child>>

  fun openAuthorizationPage()
  fun openMainPage()

  sealed class Child {
    class B(val component: Authorization) : Child()
    class A(val component: Main) : Child()
  }


  sealed class Output {
    object HomePage : Output()
    object WelcomePage : Output()
  }
}