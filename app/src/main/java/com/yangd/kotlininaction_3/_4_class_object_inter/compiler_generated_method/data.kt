package com.yangd.kotlininaction_3.`4_class_object_inter`.compiler_generated_method

fun main(args:Array<String>) {
    val client1 = Client("Alice",342562)
    val client2 = Client("Alice",342562)
    println(client1)
    println("client1.hashCode() =${client1.hashCode()}  client2.hashCode()  =${client2.hashCode()}")
    println(client1 == client2)            //在Kotlin中，==检查对象是否相等，而不是比较引用，这里会编译成调用“ClientJava”
    println(client1 === client2)
   println("----------------------数值比较--------------------")
    println(1000==1000)
    println(100==100)

    val i1:Int= 100
    val i2:Int = 100
    println(i1==i2)
    val i3:Int = 1000
    val i4:Int = 1000
    println(i3 ==i4)

    println("----------------------数值比较--------------------")

    val processed = hashSetOf(Client("Alice",234))
    println(processed.contains(Client("Alice",234)))

}
class  Client(val name:String,val postalCode:Int) {
    override fun toString(): String ="Client(name=$name, postalCode=$postalCode"

    override fun equals(other: Any?): Boolean {
        if(other ==null || other !is Client)
            return false
        return name == other.name && postalCode ==other.postalCode
    }

    fun equals(other:Client):Boolean{
        return true
    }

    override fun hashCode(): Int =name.hashCode()*31 +postalCode
}