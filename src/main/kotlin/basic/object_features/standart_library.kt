package main.object_features

fun main(){
    val list2 = listOf("Kotlin", "Java", null, "C++", "JavaScript" , null)

    list2
            .filterNotNull()   //really useful
            .filter(predicate2)
            .map(String::length)
            .forEach { println(it) }

    list2
            .filterNotNull()
            .take(3)
            .forEach { println(it) }


    list2
            .filterNotNull()
            .associate { it to it.length }
            .forEach { println("${it.value}, ${it.key}") }


    // ------------------------------with variable -----------------------------------

    val language1 = list2
            .filterNotNull()
            .last()

    println(language1)

    val language2 = list2
            .filterNotNull()
            .find { it.startsWith("Java") }

    println(language2)

    val language3 = list2
            .filterNotNull()
            .find { it.startsWith("foo") }
            .orEmpty()

    println(language3)

}

val predicate2: (String) -> Boolean = {
    it.startsWith("K")
}

fun getPrintPredicate2(): (String) -> Boolean{
    return { it.startsWith("K") }
}

