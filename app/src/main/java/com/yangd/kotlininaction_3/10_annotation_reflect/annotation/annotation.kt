package com.yangd.kotlininaction_3.`10_annotation_reflect`.annotation

import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder


//如果你使用Java中声明的注解来注解一个属性，它会被默认的应用到相应的字段上，Kotlin也可以让你声明被直接对应到属性上的注解
fun main(args: Array<String>) {

}

@Test
fun testTrue() {
    Assert.assertTrue(true)
}

@Deprecated("Use removeAt(index) instead.", ReplaceWith("removeAt(index)"))
fun remove(index: Int) {

}

class HasTempFolder {
    @get:Rule
    val folder = TemporaryFolder()

    @Test
    fun testUsingTempFolder() {
        val createdFile = folder.newFile("myfile.txt")
        val createdFolder = folder.newFolder("subfolder")
    }
}

fun test(list: List<*>) {

    @Suppress("UNCHECKED_CAST")
    val strings = list as List<String>
}