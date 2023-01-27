package com.example.coroutinebasics.flow.operator

import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take


suspend fun map( ) {

    data class Person(val name: String, val age: Int)

    val peopleFlow = flow {
        emit(Person("John", 25))
        emit(Person("Jane", 30))
        emit(Person("Bob", 35))
    }

    peopleFlow
        .map { person -> person.name }
        .collect { name -> println(name) }

}