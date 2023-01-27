package com.example.coroutinebasics.coroutine.job

import kotlinx.coroutines.*


fun main() = runBlocking {

    var job: Job? = null

    fun startProcessing() {
        job = CoroutineScope(Dispatchers.IO).launch {
            // Do some processing here
        }
    }

    fun stopProcessing() {
        job?.cancel()
    }

}
