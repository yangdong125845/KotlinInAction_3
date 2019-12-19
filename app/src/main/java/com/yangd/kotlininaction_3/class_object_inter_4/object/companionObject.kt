package com.yangd.kotlininaction_3.class_object_inter_4.`object`

import android.view.Window
import com.yangd.kotlininaction_3.class_object_inter_4.construction.SubscribingUser as SubscribingUser

fun main(args: Array<String>) {
    A.bar()

    val subscribingUser = UserCompanion.newSubscribingUser("bob@gmail.com")
    val facebookUser = UserCompanion.newFacebookUser(4)
    println(subscribingUser.nickname)


}

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

class User {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname = facebookAccountId.toString()
    }
}

class UserCompanion private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            UserCompanion(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) =
            UserCompanion(accountId.toString())
    }
}

//class Person(val name:String) {
//    companion object Loader {
//        fun fromJSON(jsonText:String):Person =...
//    }
//}


