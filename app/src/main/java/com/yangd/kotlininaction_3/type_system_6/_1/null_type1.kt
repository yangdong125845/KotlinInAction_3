package com.yangd.kotlininaction_3.type_system_6._1

import java.lang.IllegalArgumentException

fun main(args: Array<String>) {

    println(strLenSafe5("abc"))
    println(strLenSafe5(null))

    val address = Address("Elsestr. 47", 80687, "Munich", "Getmany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dmitry", jetbrains)

    printShippingLabel(person)

    printShippingLabel(
        Person(
            "Alexey",
            null
        )
    )

}

fun foo(s: String?) {
    val t: String = s ?: ""
}

fun strLenSafe5(s: String?): Int = s?.length ?: 0

fun Person.countryName1() = company?.address?.country ?: "Unknown"

fun printShippingLabel(person: Person) {
    val address = person.company?.address
        ?: throw IllegalArgumentException("NO address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}