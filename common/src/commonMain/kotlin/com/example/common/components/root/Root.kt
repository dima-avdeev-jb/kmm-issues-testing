package com.example.common.components.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.common.components.main.Main


interface Root {
  val childStack: Value<ChildStack<*, Child>>

  fun openBPage()

  sealed class Child {
    class B() : Child()
    class A(val component: Main) : Child()
  }
}
