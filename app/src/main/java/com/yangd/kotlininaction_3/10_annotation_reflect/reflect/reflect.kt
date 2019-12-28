package com.yangd.kotlininaction_3.`10_annotation_reflect`.reflect

import kotlin.reflect.full.memberProperties

fun main(args: Array<String>) {

    val person = Person("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }

    val kFunction = ::foo
    kFunction.call(42)

    val kFunction_1 = ::sum
    println(kFunction_1.invoke(1, 2) + kFunction_1(3, 4))
    //kFunction_1(1)  //No value passed for parameter 'y'


    val kProperty = ::counter
    kProperty.setter.call(21)
    println(kProperty.get())

    val person_ = Person("Alice",29)
    val memberProperty = Person::age
    println(memberProperty.get(person_))


}

class Person(val name: String, val age: Int)

fun foo(x: Int) = println(x)

fun sum(x: Int, y: Int) = x + y

var counter = 0



