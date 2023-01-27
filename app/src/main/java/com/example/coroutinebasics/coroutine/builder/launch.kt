package com.example.coroutinebasics.coroutine.builder

import kotlinx.coroutines.*

fun main() {

    val job = GlobalScope.launch {
        // This block of code will run on a separate thread
        val data = fetchDataFromAPI()

        withContext(Dispatchers.Main) {
            // This block of code will run on the main thread
            updateUI(data)
        }
    }

}

suspend fun fetchDataFromAPI(): String {

    delay(1000) // Simulate a delay of 1 second
    return "Data from API"
}

fun updateUI(data: String) {
    // Pretend this function updates the UI with the fetched data
    println("UI updated with data: $data")
}
