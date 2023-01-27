package com.example.coroutinebasics.flow.operator

import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@OptIn(ExperimentalTime::class)
fun main() = runBlocking {

    data class CustomObject(val name: String, val age: Int)

    val customObjectFlow = flow {
        emit(CustomObject("John", 25))
        emit(CustomObject("Jane", 30))
        emit(CustomObject("Bob", 35))
        emit(CustomObject("Samantha", 40))
        emit(CustomObject("Mike", 45))
    }

    val timeTaken = measureTime {
        customObjectFlow
            .buffer(3) // buffer up to 3 objects at a time
            .collect { objects ->
                // do something with the buffered objects
                println("Buffered objects: $objects")
            }
    }

    println("Time taken to buffer and collect objects: $timeTaken ms");
}
