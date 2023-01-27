package com.example.coroutinebasics.flow.builder

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun networkAvailabilityFlow(context: Context): Flow<Boolean>
        = callbackFlow {
    val callback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            trySend(true)
        }
        override fun onLost(network: Network) {
            trySend(false)
        }
    }
    val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager
    manager.registerNetworkCallback(NetworkRequest.Builder().run {
        addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        build()
    }, callback)

    awaitClose {
        manager.unregisterNetworkCallback(callback)
    }
}