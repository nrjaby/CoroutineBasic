package com.example.coroutinebasics.coroutine.job

import kotlinx.coroutines.*

fun main() = runBlocking {

    val timeout = 1000L // 1 second timeout
    val job = launch {
        try {
            withTimeout(timeout) {

                delay(1500)
            }
        } catch (e: TimeoutCancellationException) {
            println("The operation timed out after $timeout milliseconds")
        }
    }
}
