package main.syntax

val _name = "Nate";
var _greeting: String? =  null

fun main(){
//    mainWhen1()
    mainWhen2()
}

fun mainWhen1(){
    _greeting = "What's up "

    when(_greeting){
        null -> println("Hello")
        else -> print(_greeting)
    }

    println(_name)
}

fun mainWhen2(){
    _greeting = "What's up "

    val greetingToPrint = when(_greeting){
        null -> "Boom"
        else -> _greeting
    }
    println(greetingToPrint)
}