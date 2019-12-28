package com.yangd.kotlininaction_3.`7_overload_appoint`

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

fun main(args: Array<String>) {

    val p = Person_Delegate_2("Dmitry", 34, 2000)
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

class ObservableProperty_1(
    var propValue: Int,
    val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(p: Person_Delegate_2, prop: KProperty<*>): Int = propValue
    operator fun setValue(p: Person_Delegate_2, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class Person_Delegate_2(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    var age: Int by ObservableProperty_1(age, changeSupport)

    var salary: Int by ObservableProperty_1(salary, changeSupport)
}