package com.yangd.kotlininaction3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(verticalLayout {
            val name = editText()
            button("Say Hello") {
                onClick {
                    toast("Hello, ${name.text}!")
                }
            }
        })
    }

}
