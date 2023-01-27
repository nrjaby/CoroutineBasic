package com.example.coroutinebasics.flow.builder

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Here collect operator to print out the updated values.
 * Note that MutableStateFlow is a Flow that is backed by a MutableState, so we can use the value property to set or get the value.
 *
 **/

suspend fun mutableStateFlow( ) {

    val mutableStateFlow = MutableStateFlow(0)
    val scope = CoroutineScope(Dispatchers.IO)

    mutableStateFlow.value = 5
    mutableStateFlow.value = 10


    scope.launch {
        mutableStateFlow.collect {
            println("Current 1 value: $it")
        }
    }

}