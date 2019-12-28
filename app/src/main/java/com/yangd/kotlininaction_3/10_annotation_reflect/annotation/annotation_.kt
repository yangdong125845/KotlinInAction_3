package com.yangd.kotlininaction_3.`10_annotation_reflect`.annotation

import kotlin.reflect.KClass

fun main(args: Array<String>) {

}

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

annotation class JsonName(val name: String)


@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class BindingAnnotation

@BindingAnnotation
annotation class MyBinding

annotation class DeserializeInterface(val targetClass: KClass<out Any>)

//annotation class CustomSerializer{
//    val serializerClass:KClass<out ValueSerializer<*>>
//}