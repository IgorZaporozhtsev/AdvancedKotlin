package main.syntax

fun greetPerson(greeting:String, name:String) = println("$greeting $name")

fun main(){
    greetPerson(greeting = "hi", name = "Nate") //we can change order
}