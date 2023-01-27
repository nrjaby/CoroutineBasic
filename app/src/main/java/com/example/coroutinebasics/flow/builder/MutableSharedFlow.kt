package com.example.coroutinebasics.flow.builder

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * Note that both coroutines receive the same values in the order they were emitted, as we expected.
 * This can be useful when we want multiple parts of our program to react to the same stream of data.
 *
 **/

suspend fun mutableSharedFlow() {

    val scope = CoroutineScope(Dispatchers.IO)

    val sharedFlow = MutableSharedFlow<String>()

    // Launch two coroutines that collect the shared flow
    scope.launch {
        sharedFlow.asSharedFlow().collect {
            println("Coroutine 1: $it")
        }
    }

    scope.launch {
        sharedFlow.asSharedFlow().collect {
            println("Coroutine 2: $it")
        }
    }

    // Emit some values
    sharedFlow.emit("Hello")
    sharedFlow.emit("World")

    // Wait for a bit
    delay(1000)

    // Emit some more values
    sharedFlow.emit("Goodbye")
    sharedFlow.emit("Universe")
}
