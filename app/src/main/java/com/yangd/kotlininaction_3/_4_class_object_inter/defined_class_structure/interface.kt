package com.yangd.kotlininaction_3.`4_class_object_inter`.defined_class_structure


fun main(args:Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}
interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b:Boolean) =
            println("I ${if (b)  "got" else "lost"} focus")

    fun showOff() = println("I'm focusable!")
}

class Button:Clickable,Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun click() = println("I was clicked")
}

open class RichButton :Clickable {

    fun disable() {}

    open fun animate() {}

    override fun click() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

abstract  class  Animated {
    abstract  fun animate()

    open fun stopAnimating() {

    }

    fun animateTwice() {

    }
}

internal open class  TalkativeButton:Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

//类的基础类型和类型参数列表中用到的所有类，或者函数的签名都有与这个类或者函数本身相同的可见性
//类的扩展函数不能访问它的private和protected成员
//Kotlin中一个外部类不能看到其内部（或者嵌套）类中的private成员
//  fun TalkativeButton.giveSpeech() {
//
//    yell()
//    whisper()
//}
