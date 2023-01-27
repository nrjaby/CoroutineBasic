package com.example.coroutinebasics.flow.operator

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow

suspend fun flatMapConcat() {

    getUsers()
        .flatMapConcat { user ->
            getOrdersForUser(user)
        }.collect { order ->
            println(order)
        }

}

data class User(val id: Int, val name: String)

fun getUsers(): Flow<User> = flow {

    emit(User(1, "John"))
    emit(User(2, "Jane"))
    emit(User(3, "Bob"))
}

fun getOrdersForUser(user: User): Flow<String> = flow {
    emit("Order 1 for user ${user.name}")
    emit("Order 2 for user ${user.name}")
}
