package com.yangd.kotlininaction_3.type_system_6._1

fun main(args: Array<String>) {

    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let {
        sendEmailTo(it)
    }

    getTheBestPersonInTheWorld()
        ?.let { sendEmailTo(it.firstName) }

    verifyUserInput(" ")
    verifyUserInput(null)

    printHashCode(null)
//    printHashCode1(null)

}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun getTheBestPersonInTheWorld(): Person_6? = null

fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}

fun String?.isNullOrBlank(): Boolean =
    this == null || this.isBlank()

fun <T> printHashCode(t: T) {
    println(t?.hashCode())
}

fun <T:Any> printHashCode1(t:T) {
    println(t.hashCode())
}