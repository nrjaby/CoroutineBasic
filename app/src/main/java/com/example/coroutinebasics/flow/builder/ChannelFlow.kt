package com.example.coroutinebasics.flow.builder

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch

suspend fun channelFlow() {

    val scope = CoroutineScope(Dispatchers.IO)

    val flow = channelFlow {
        println("send : 1")
        send("1")
        println("send : 2")
        send("2")
    }

    // scope.launch {  }
    flow.collect {
        println("collect $it")
        delay(5000)
    }

}