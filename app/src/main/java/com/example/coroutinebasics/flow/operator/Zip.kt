package com.example.coroutinebasics.flow.operator

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip

suspend fun zip() {
    data class Person(val name: String, val age: Int)

    val peopleFlow = flow {
        emit(Person("John", 25))
        emit(Person("Jane", 30))
        emit(Person("Bob", 35))
    }

    val agesFlow = flow {
        emit(20)
        emit(25)
        emit(30)
    }

    peopleFlow.zip(agesFlow) { person, age ->
        "${person.name} is ${person.age} and desired age is $age"
    }.collect {
        println(it)
    }

}