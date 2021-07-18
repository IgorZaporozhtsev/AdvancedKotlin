package main
const val question = "life, the universe, and everything"
const val answer = 42

fun main() {

//    val joinToString = listOf("1", "2", "3", "4", "5", "6").joinToString()
//    println(joinToString)
//
//    val toString = listOf("1", "2", "3", "4", "5", "6").toString()
//    println(toString)
//
//
//    val tripleQuotedString = """
//    #question = "$question"
//    #answer = $answer""".trimMargin("#")
//
//    println(tripleQuotedString)
//
//    val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
//
//    fun getPattern(): String = """d{2} $month d{4}"""
//
//    println(getPattern())


        println(isValidIdentifier("name"))   // true
        println(isValidIdentifier("_name"))  // true
        println(isValidIdentifier("_12"))    // true
        println(isValidIdentifier(""))       // false
        println(isValidIdentifier("012"))    // false
        println(isValidIdentifier("no$"))    // false
}

fun String.onlyLetters() = all { it.isLetter() }

fun isValidIdentifier(s: String): Boolean {

    if(s.onlyLetters()){
        return true
    }
    if("_" !in s) return false
    if(s.isEmpty()) return false

    return true
}

