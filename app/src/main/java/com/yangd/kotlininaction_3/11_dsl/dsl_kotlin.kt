package com.yangd.kotlininaction_3.`11_dsl`

import java.lang.AssertionError

fun main(args: Array<String>) {
    "s" should startWith("kot")
    "kotlin" should start with "kot"

}

interface Matcher<T> {
    fun test(value: T)
}

class startWith(val prefix: String) : Matcher<String> {
    override fun test(value: String) {
        if (!value.startsWith(prefix)) {
            throw AssertionError("String $value does not start with $prefix")
        }
    }
}

infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)


//2
object start

infix fun String.should(x: start): StartWrapper = StartWrapper(this)

class StartWrapper(val value: String) {
    infix fun with(prefix: String) {
        if(!value.startsWith(prefix)) {
            throw  AssertionError("String does not start with $prefix: $value")
        }
    }
}