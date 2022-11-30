package com.example.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.example.common.components.root.Root
import com.example.common.components.root.RootComponent

@OptIn(ExperimentalDecomposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App(root: RootComponent) {
  val childStack by root.childStack.subscribeAsState()

  Children(
    stack = childStack,
    modifier = Modifier.fillMaxSize(),
    animation = stackAnimation(fade()) //TODO without animation, all work's fine
  ) {
    Box(
      modifier = Modifier.fillMaxSize()
    ) {
      when (val child = it.instance) {
        is Root.Child.A -> {
          Scaffold {//TODO without material3 Scaffold, all work's fine
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
              Button(
                onClick = {
                  child.component.openB()
                }) {
                Text("A", Modifier.padding(30.dp))
              }
            }
          }
        }
        is Root.Child.B -> {
          Text("Bug fixed, if you see this message")
        }
      }
    }
  }
}
