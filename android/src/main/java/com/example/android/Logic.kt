package com.example.android

import android.os.Parcelable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.parcelize.Parcelize

interface Root {
    val childStack: Value<ChildStack<*, Child>>
    sealed class Child {
        object A : Child()
        object B : Child()
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
                is Config.A -> Root.Child.A
                is Config.B -> Root.Child.B
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
