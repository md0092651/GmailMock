package com.coroutinelab.presentation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

var balance = 100000
val mutex = Mutex()

fun main() =
    runBlocking {
        repeat(10) {
            launch {
                safeWithdraw(2)
                println("balance is now $balance [${Thread.currentThread().name}]")
            }
        }

        println("Final balance: $balance")
    }

suspend fun safeWithdraw(amount: Int) {
    mutex.withLock {
        // This block is protected by the mutex
        if (balance >= amount) {
            balance -= amount
            delay(1000)
        }
    }
}
