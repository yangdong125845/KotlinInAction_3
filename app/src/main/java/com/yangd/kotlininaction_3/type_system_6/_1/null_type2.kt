package com.yangd.kotlininaction_3.type_system_6._1

fun main(args: Array<String>) {

    val p1 = Person_6("Dmitry", "Jemerov")
    val p2 = Person_6("Dmitry", "Jemerov")
    println(p1 == p2)
    println(p1.equals(42))
    ignoreNulls(null)

}

class Person_6(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person_6 ?: return false

        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()
}

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}