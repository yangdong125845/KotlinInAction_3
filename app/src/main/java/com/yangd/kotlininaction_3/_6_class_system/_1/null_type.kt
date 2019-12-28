package com.yangd.kotlininaction_3_6_type_system._1

fun main(args: Array<String>) {
    // strlen(null)  //Null can not be a value of a non-null type String

    val x: String? = null
//    val y:String = x  //Null can not be a value of a non-null type String
//    strlen(x)      //Type mismatch.Required:StringFound:String?

    println(strLenSafe1(x))
    println(strLenSafe1("abc"))

    printAllCaps("abc")
    printAllCaps(null)

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))

    val person = Person("Dmitry", null)
    println(person.countryName())

}

fun strlen(s: String) = s.length

fun strLenSafe(s: String?) = s?.length

fun strLenSafe1(s: String?): Int = if (s != null) s.length else 0

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)


fun Person.countryName(): String {
    val country = this.company?.address?.country
    return if (country != null) country else "Unknown"
}
