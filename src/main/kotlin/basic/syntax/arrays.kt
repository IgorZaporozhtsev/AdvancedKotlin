package main.syntax

fun main(){
    val infestingThings = arrayOf("zero", "one", "two")
    println(infestingThings.size)

    //1
    for (thing in infestingThings){
        println("$thing ")
    }

    //2
    infestingThings.forEach {
        //it - is default name for each elem in the Array
        println(it)
    }

    //3
    infestingThings.forEach { thing -> println(thing) }

    //4
    infestingThings.forEachIndexed { index, thing -> println("$thing is at the $index index") }


}