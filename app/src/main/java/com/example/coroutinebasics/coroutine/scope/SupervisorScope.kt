package com.example.coroutinebasics.coroutine.scope

import kotlinx.coroutines.*

fun main() = runBlocking {

    supervisorScope {

        val task1 = launch {
            println("Task 1 started")
            delay(100)
            if (true) throw Exception("Oops!")
            println("Task 1 completed!")
        }

        val task2 = launch {
            println("Task 2 started")
            delay(1000)
            println("Task 2 completed!")
        }

        listOf(task1, task2).joinAll()
        println("Finished waiting for both tasks")
    }

    print("Done!")

}
