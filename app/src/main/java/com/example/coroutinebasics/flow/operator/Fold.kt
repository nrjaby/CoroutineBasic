package com.example.coroutinebasics.flow.operator

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold

suspend fun main() {

    data class User(val name: String, val age: Int)

    val usersFlow = flowOf(User("John", 25), User("Jane", 30), User("Bob", 35))

    val oldestUser = usersFlow.fold(User("", 0)) { oldest, current ->
        if (current.age > oldest.age) current else oldest
    }

     println("The oldest user is: $oldestUser")

}