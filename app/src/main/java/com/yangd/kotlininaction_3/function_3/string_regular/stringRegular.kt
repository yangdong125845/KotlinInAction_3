package com.yangd.kotlininaction_3.function_3.string_regular

import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split("."))
    println("12.345-6.A".split(".", "-"))

    parsePath("C:/Users/yangdong/Desktop/Study/Kotlin实战@www.java1234.com.pdf")
    parsePath1("C:/Users/yangdong/Desktop/Study/Kotlin实战@www.java1234.com.pdf")

    val kotlinLogo = """|//
.|//
                                ./ \""".trimMargin()
    println(kotlinLogo.trimMargin("."))
}


fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

fun parsePath1(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}


class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Address"
        )
    }
}

fun saveUser1(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id} empty $fieldName")
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}

fun saveUser2(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: " + "empty $fieldName"
            )
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user $id: empty $fieldName"
            )
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser3(user: User) {
    user.validateBeforeSave()
}
