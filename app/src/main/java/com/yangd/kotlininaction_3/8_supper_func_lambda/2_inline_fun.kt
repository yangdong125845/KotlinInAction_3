package com.yangd.kotlininaction_3.`8_supper_func_lambda`

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.Lock as Lock

//见5.4.1

fun main(argss: Array<String>) {
    val l = ReentrantLock()
    synchronized(l) {

    }

    l.withLock_ {
        //access the resource proteted by this lock
    }
}

inline fun <T> sunchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}

fun foo(lock: Lock) {
    println("Before sync")
    synchronized(lock) {
        println("Action")
    }
    println("After sync")
}

fun _foo_(lock: Lock) {
    println("Before sync")
    lock.lock()
    try {
        println("Action")
    } finally {
        lock.unlock()
    }
    println("After sync")
}

class LockOwner(val lock: Lock) {
    fun runUnderLock(body: () -> Unit) {
        synchronized(lock, body)
    }

    fun _runUnderLOck_(body: () -> Unit) {
        lock.lock()
        try {
            body()
        } finally {
            lock.unlock()
        }
    }
}

fun <T> Lock.withLock_(action: () -> T): T {
    lock()
    try {
        return action()
    } finally {
        unlock()
    }
}

fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use { br ->
        return br.readLine()
    }
}