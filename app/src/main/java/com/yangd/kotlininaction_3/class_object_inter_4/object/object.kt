package com.yangd.kotlininaction_3.class_object_inter_4.`object`

import com.yangd.kotlininaction3.definition_1.first_1.Person
import java.io.File


fun main(args: Array<String>) {
    Payroll.allEmployees.add(Person("Bob", 12))
    Payroll.calculateSalary()

    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(PersonObject("Bob"), PersonObject("Alice"))
    println(persons.sortedWith(PersonObject.NameComparator))

}

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {

        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File?, o2: File?): Int {
        return o2?.path?.let { o1?.path?.compareTo(it, ignoreCase = true) }!!
    }

}

data class PersonObject(val name: String) {
    object NameComparator : Comparator<PersonObject> {
        override fun compare(o1: PersonObject, o2: PersonObject): Int = o1.name.compareTo(o2.name)
    }
}