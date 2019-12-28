package com.yangd.kotlininaction_3.`4_class_object_inter`.defined_class_structure

import java.io.Serializable

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

/*
Java   java.io.NotSerializable

public class Button implements View {
    @Override
    public State getCurrentState()
    return new ButtonState ();
    ®Override
    public void restoreState(State state) {}
public class ButtonState implements State { }
}

 */

class Button1 : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class ButtonState : State {

    }
}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}

//详见 2.3.5 basic_2/sselect/smaart_cast

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
    }
