package basic.scope_functions

val numbers = mutableListOf("one", "two", "three", "four", "five")

fun main() {

    val resultList = numbers.map { it.length }.filter { it > 3 }
    println(resultList)

    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let {
        println(it)
        // and more function calls if needed
    }

    val str: String? = "Hello"
    //processNonNullString(str)       // compilation error: str can be null
    val length = str?.let {
        println("let() called on $it")
        processNonNullString(it)      // OK: 'it' is not null inside '?.let { }'
        it.length
    }

    val numbers_sec = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers_sec.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!" + firstItem + "!"
    }.uppercase()
    println("First item after modifications: '$modifiedFirstItem'")
}


fun processNonNullString(it: String) {
    print("")
}
