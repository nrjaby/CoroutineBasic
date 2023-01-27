package com.example.coroutinebasics.flow.builder

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow


class MyData {

    fun getData() = flow {

        for (i in 1..10) {
            emit(i)
            delay(1000)
        }

    }

}


suspend fun flowBuilder() {

    val data = MyData()

    data.getData().collect() {

        println("emitted number is $it")

    }

}