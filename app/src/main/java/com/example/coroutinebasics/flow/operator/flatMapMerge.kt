package com.example.coroutinebasics.flow.operator

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow

/**
 * flatMapMerge is similar to flatMapConcat, but it will merge the flows emitted by the lambda function passed to it.
 * This means that it may emit items out of order and the order of the final items may be different than the order of the original flows.
 **/

data class MyObject(val name: String, val age: Int)

fun getMyObjects(): Flow<MyObject> {
    return flow {
        emit(MyObject("John", 25))
        emit(MyObject("Jane", 30))
        emit(MyObject("Bob", 35))
    }
}

fun getAdditionalData(myObject: MyObject): Flow<String> {
    return flow {
        emit("Additional data for ${myObject.name}")
    }
}

suspend fun main() {
    getMyObjects().flatMapMerge { myObject -> getAdditionalData(myObject) }.collect {
            println(it)
        }
}
