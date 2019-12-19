package com.yangd.kotlininaction_3.basic_2.class_property

class Person(val name: String, var isMarried: Boolean)
//字段和其访问器的组合常常被叫作属性，属性有一个对应的支持字段来保存属性的值。
fun main(args:Array<String>) {
    val person = Person("Bob",true)
    println(person.name)
    println(person.isMarried)
}