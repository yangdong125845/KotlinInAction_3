package com.yangd.kotlininaction_3.class_object_inter_4.construction

fun main(args: Array<String>) {
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)

    val user = User_Property_3("Alice")
    user.address = "Elsenheimerstrasse 47, 8068 7 Muenchen"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
}

interface User_Property {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User_Property

class SubscribingUser(val email: String) : User_Property {

    //自定义getter实现，这个属性没有一个支持字段来存储值，在每次访问时计算
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : User_Property {

    //有一个支持字段来存储在类初始化时计算得到的数据
    override val nickname: String = getFacebookName(accountId)

    fun getFacebookName(accountId: Int) = accountId.toString()
}

//接口中还可以包含具有getter和setter的属性，只要它们没有引用一个支持字段（支持字段需要在接口中存储状态，而这时不允许的）

interface User_Property_2 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class User_Property_3(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
            Address was changed for $name:
            "$field" -> "$value".  //读取支持字段的值
        """.trimIndent()
            )
            field = value // 更新支持字段的值
        }
}

//如果你显式 引用或者使用默认 访问器实现，编译
//器会为属性 成支持字段 如果你提供了 个自定义的访问器实现并且没有使用
//fie ld （如果属性是 val 类型，就是 ；而如果是可变属性， 是两个访问器），
//支持宇段将不会被呈现出来

class LengthCounter{
    var counter:Int = 0
    private set                      //不能再类外部修改这个属性

    fun addWord(word:String) {
        counter += word.length
    }
}