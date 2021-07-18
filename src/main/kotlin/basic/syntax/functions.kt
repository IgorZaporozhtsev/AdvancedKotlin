package main.syntax

fun main(){
//    println("Hello")
//    println(getGreeting())
//    sayHello()
//    println(anotherGreeting())
//    println(moreGreeting())
//
//        oneParameter("Wave me")
//        oneParameterShort("Wave me 2")
//        oneParameterShorter("Wave me 3")

    twoParameters("Hi there", "Peter")
}

//8.

fun twoParameters(greeting:String, name:String) =
        println("$greeting $name")

//7.

fun oneParameterShorter(itemToGreet:String) =  println("$itemToGreet Peter")

//6.
fun oneParameterShort(itemToGreet:String){
    val message = "$itemToGreet Peter"
    println(message)
}

//5.
fun oneParameter(itemToGreet:String){
    val message = itemToGreet + " Peter"
    println(message)
}

//4.
fun sayHello(): Unit{
    println("I'm Unit")
}

//3.
fun moreGreeting() = "More Hello Kotlin"

//2.
fun anotherGreeting(): String = "Another Hello Kotlin"

//1.
fun getGreeting():String {
    return "Hello Kotlin"
}

