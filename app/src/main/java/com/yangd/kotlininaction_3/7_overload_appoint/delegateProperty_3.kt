package com.yangd.kotlininaction_3.`7_overload_appoint`

import java.beans.PropertyChangeListener
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main(args: Array<String>) {

    val p = Person_Delegate_3("Dmitry", 34, 2000)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println(
                "Property ${event.propertyName} changed " +
                        "from ${event.oldValue} to ${event.newValue}"
            )
        }
    )
    p.age = 35
    p.salary = 2100

}

class Person_Delegate_3(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    private val observer = {
        prop:KProperty<*>,oldValue:Int,newValue:Int ->
        changeSupport.firePropertyChange(prop.name,oldValue, newValue)
    }

    var age: Int by Delegates.observable(age,observer)
    var salary: Int by Delegates.observable(salary,observer)
}