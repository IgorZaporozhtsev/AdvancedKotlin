package main.syntax

fun greetings3(greeting:String, vararg names:String) { //vararg
    names.forEach {
        name -> println("$greeting $name")
    }
}

fun greetPerson2(greeting:String = "Hello", name:String) = println("$greeting $name")

fun main(){
    greetPerson2(name = "Peter") //use only one parameter
    greetPerson2("Hi", name = "Peter") //use only one parameter
}