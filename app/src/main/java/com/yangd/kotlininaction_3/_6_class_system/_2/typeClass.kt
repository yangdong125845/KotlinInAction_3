package com.yangd.kotlininaction_3._6_class_system._2

import com.yangd.kotlininaction_3_6_type_system._1.Company
import java.lang.IllegalStateException

fun main(args: Array<String>) {

    showProgress(146)
    println(Person_Type("Sam", 35).isOlderThan(Person_Type("Amy", 42)))
    println(Person_Type("Sam", 35).isOlderThan(Person_Type("Jane")))

    fail("Error occurred")

    val address = Company("google",null).address?: fail("No address")
    println(address.city)
}

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}

data class Person_Type(val name: String, val age: Int? = null) {

    fun isOlderThan(other: Person_Type): Boolean? {
        if (age == null || other.age == null) {
            return null
        }
        return age > other.age
    }
}

interface Processor<T> {
    fun process(): T
}

class NoResultProcessor : Processor<Unit> {
    override fun process() {
        //fo stuff
    }
}

fun fail(message:String):Nothing {
    throw IllegalStateException(message)
}