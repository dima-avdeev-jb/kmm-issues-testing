package com.example.android

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
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value

@OptIn(ExperimentalDecomposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun UserInterface(childStackValue: Value<ChildStack<*, Root.Child>>) {
    val childStack by childStackValue.subscribeAsState()
    Children(
        stack = childStack,
        modifier = Modifier.fillMaxSize(),
        animation = stackAnimation(fade()) //TODO without animation, all work's fine
    ) {
        when (it.instance) {
            is Root.Child.A -> {
                Scaffold {//TODO without material3 Scaffold, all work's fine
                    Button(
                        onClick = { navigation.replaceCurrent(Config.B) }
                    ) {
                        Text("A", Modifier.padding(40.dp))
                    }
                }
            }

            is Root.Child.B -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Bug fixed, if you see this message")
                }
            }
        }
    }
}
