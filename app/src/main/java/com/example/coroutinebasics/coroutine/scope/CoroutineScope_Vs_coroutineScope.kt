package com.example.coroutinebasics.coroutine.scope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking { // this: CoroutineScope


    // Un-structured Coroutine
    println("CoroutineScope : " + CoroutineScope())

    // Structured Coroutine
    println("coroutineScope : " + coroutineScope())


}

private suspend fun CoroutineScope(): Int {
    var result = 0
    val scope = kotlinx.coroutines.CoroutineScope(Dispatchers.IO)
    scope.launch {
        for (i in 0 until 100) {
            kotlinx.coroutines.delay(10)
            result++
        }
    }

    return result
}

private suspend fun coroutineScope(): Int {
    var result = 0
    coroutineScope {
        for (i in 0 until 100) {
            kotlinx.coroutines.delay(10)
            result++
        }
    }
    return result
}