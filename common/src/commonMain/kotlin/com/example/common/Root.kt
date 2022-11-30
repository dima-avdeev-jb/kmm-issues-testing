package com.example.common

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value


interface Root {
  val childStack: Value<ChildStack<*, Child>>

  fun openBPage()

  sealed class Child {
    class B() : Child()
    class A(val component: ScreenA) : Child()
  }
}
