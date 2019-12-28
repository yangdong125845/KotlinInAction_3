package com.yangd.kotlininaction_3.`10_annotation_reflect`.reflect

import kotlin.reflect.full.memberProperties

fun main(args:Array<String>) {

}


private  fun StringBuilder.serializeObject(obj:Any) {

//    val kClass = obj.javaClass.kotlin
//    val properties = kClass.memberProperties
//
//    properties.joinToStringBuilder(
//        this,prefix = "{",postfix = "}") {
//        prop -> serialS
//    }
//    )

}

fun serialize(obj:Any):String = buildString { serializeObject(obj) }