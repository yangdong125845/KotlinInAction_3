package com.yangd.kotlininaction_3._4_class_object_inter.construction

import android.content.Context
import android.util.AttributeSet

fun main(args:Array<String>) {

    val alice = User("Alice")
    println(alice.isSubscribed)
    val bob = User("Bob",false)
    println(bob.isSubscribed)
    val carol = User("Carol",isSubscribed = false)
    println(carol.isSubscribed)

}

class User1(val nickname: String)

// 注意住构造方法中没有val
class User2 constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

// 注意住构造方法中没有val
class User3(_nickname: String) {
    val nickname = _nickname
}

class User(
    val nickname: String,
    val isSubscribed: Boolean = true
)

open class UserUpper(val nickname: String){}

class TwitterUser(  nickname: String):UserUpper(nickname){

}

open class Button

class RadioButton:Button()

class Secretive private constructor(){}

open class View{
    constructor(ctx: Context){

    }

    constructor(ctx: Context, attr: AttributeSet?) {

    }
}

class MyButton : View{
    constructor(ctx: Context):super(ctx){

    }

    constructor(ctx: Context,attr: AttributeSet):super(ctx, attr){

    }
}


class MyBotton1:View {
    constructor(ctx: Context):this(ctx,null){

    }

    constructor(ctx: Context, attr: AttributeSet?):super(ctx, attr){

    }
}


