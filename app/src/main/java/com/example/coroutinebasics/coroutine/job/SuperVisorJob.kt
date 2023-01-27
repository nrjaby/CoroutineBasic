package com.example.coroutinebasics.coroutine.job

import kotlinx.coroutines.*


fun main() {
    runBlocking {
        val supervisor = SupervisorJob()
        val scope = CoroutineScope(coroutineContext + supervisor)

        scope.launch {
            try {
                val firstChild = launch {
                    println("First child is starting")
                    delay(500)
                    throw IllegalStateException("First child failed")
                }
                firstChild.join()
            } catch (e: IllegalStateException) {
                println("First child failed with exception: ${e.message}")
            }
        }

        scope.launch {
            println("Second child is starting")
            delay(1000)
            println("Second child is done")
        }

        delay(2000)
    }
}