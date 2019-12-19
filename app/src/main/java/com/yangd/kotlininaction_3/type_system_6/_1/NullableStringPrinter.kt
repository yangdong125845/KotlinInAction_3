package com.yangd.kotlininaction_3.type_system_6._1

class NullableStringPrinter : StringProcessor {
    override fun process(value: String?) {
        if (value != null) {
            println(value)
        }
    }
}