package com.yangd.kotlininaction_3.`5_lambda`

fun main(args: Array<String>) {

    { println(42) }()

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)

    println(people.maxBy { it.age })
    println(people.maxBy(Person::age))

    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    run { println(42) }

    people.maxBy({ p: Person -> p.age })   //完整的lanbda
    people.maxBy() { p: Person -> p.age }  //如果lanbda表达式是函数调用的最后一个实参，他可以放到括号的外边
    people.maxBy { p: Person -> p.age }      //当lanbda是函数唯一的实参时，还可以去掉调用代码中的空括号对
    people.maxBy { p -> p.age }
    people.maxBy { it.age } //如果当前上下文期望的是只有一个参数的lanbda且这个参数的类型可以推断出来，就会生成这个名称

    val getAge = {p:Person  -> p.age}
    val getAge1 = Person::age
    people.maxBy(getAge)
    people.maxBy(getAge1)

    val names = people.joinToString(separator = " ", transform = { p: Person -> p.name })
    println(names)

    people.joinToString(" ") { p: Person -> p.name }

    val sum1 = { x:Int,y:Int ->
        println("Computing the sum of $x and $y...")
        x+y
    }

    println(sum1(1,2))

    val errors = listOf("403 Forbidden","404 Not Found")
    printMessagesWithPrefix(errors,"Error:")

    val responses = listOf("200 OK","418 I'm a teapot","500 Internal Server Error")
    printProblemCounts(responses)

    run(::salute)

    val action = {person:Person,message:String -> sendEmail(person, message)}

    val nextAction = ::sendEmail

    //构造方法引用存储或者延期执行创建类实例的动作
    val createPerson = ::Person
    val p = createPerson("Alice",29)
    println(p)

    //引用扩展函数
    val predicate = Person::isAdult

    val p1 = Person("Dmitry",34)
    val personsAgeFunction = Person::age
    println(personsAgeFunction(p1))
    val dmitrysAgeFunction = p1::age
    println(dmitrysAgeFunction)

}

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }

    println(theOldest)
}

fun printMessagesWithPrefix(messages:Collection<String>,prefix:String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if(it.startsWith("4")){
            clientErrors++
        }else if(it.startsWith("5")){
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

fun salute() = println("Salute!")

fun sendEmail(person: Person,message:String){

}

fun Person.isAdult() = age>=21
