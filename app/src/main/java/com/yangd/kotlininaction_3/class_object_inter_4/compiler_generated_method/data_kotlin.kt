package com.yangd.kotlininaction_3.class_object_inter_4.compiler_generated_method

fun main(args:Array<String>) {
    val bob1 = ClientKotlin1("Bob",124)
    println(bob1.copy(postalCode = 345))

    val bob = ClientKotlin("Bob",124)
    println(bob.copy(postalCode = 345))

    val cset = CountingSet<Int>()
    cset.addAll(listOf(1,2,2))
    println("${cset.objectAdded} objects were added, ${cset.size} remain")
}

data class ClientKotlin(val name:String,val postalCode:Int)

 class ClientKotlin1(val name:String,val postalCode:Int) {

    fun copy(name: String = this.name,postalCode: Int = this.postalCode) = ClientKotlin1(name,postalCode)
}

class CountingSet<T>(
    val innerSet:MutableCollection<T> = HashSet<T>()
) :MutableCollection<T> by  innerSet {         //将MutableCollection的实现委托给innerSet
    var objectAdded = 0
    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded+=elements.size
        return innerSet.addAll(elements)
    }
}