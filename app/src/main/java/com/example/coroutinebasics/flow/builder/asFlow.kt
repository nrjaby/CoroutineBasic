package com.example.coroutinebasics.flow.builder

import kotlinx.coroutines.flow.asFlow

suspend fun asFlowBuilder() {

    val userNameFlow = listOf("Niraj", "Anuj", "Atiq", "Abhay").asFlow()
    userNameFlow.collect {
        println("$it")
    }

// Convert Int range to flow
    (1..10).asFlow().collect { println("$it") }


}