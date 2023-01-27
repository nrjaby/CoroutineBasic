package com.example.coroutinebasics.flow.operator

import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

suspend fun flatMapLatest() {

    data class User(val id: Int, val name: String)

    val userIdFlow = flow {
        emit(1)
        emit(2)
        emit(3)
    }

    val userFlow = userIdFlow.flatMapLatest { id ->
        flow {
            emit(User(id, "User $id"))
        }
    }

    userFlow.collect { user ->
        println("User received: $user")
    }

}