package main.object_features

import java.util.function.Predicate

fun main(){
    val list = listOf("Kotlin", "Java", "C++", "JavaScript")
    printFilteredStrings(list) { str -> str == "Java"}
    printFilteredStrings(list, predicate)
    printFilteredStrings(list, getPrintPredicate())
    printRetrievedStrings(list,  null)
}

val predicate: (String) -> Boolean = {
    it.startsWith("K")
}

//higher order functions
fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach {
        if (predicate(it)) println(it)
    }
}


fun printRetrievedStrings(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        if (predicate?.invoke(it) == true) println(it)
    }
}

fun getPrintPredicate(): (String) -> Boolean{
    return { it.startsWith("K") }
}


