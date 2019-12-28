package com.yangd.kotlininaction_3._6_class_system._1

class NullableStringPrinter : StringProcessor {
    override fun process(value: String?) {
        if (value != null) {
            println(value)
        }
    }
}