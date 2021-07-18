package main.syntax

fun main(){
    val letter1 = isLetter('q')
    val letter2 = isLetter('*')
    //println("$letter1 and $letter2")

    val digit = isNotDigit('x')
    //println(digit)


    println("Kotlin" in "Java".."Scala") // между J т S есть K в алфавитном порядке
    println("ball" in "a".."k") // между a т k есть b в алфавитном порядке
    println("zoo" in "a".."k") // между a т k есть z в алфавитном порядке
    println("Kotlin" in setOf("Java", "Scala"))
}

fun isLetter(c: Char) = c in 'a' .. 'z' || c in 'A' .. 'Z'

fun isNotDigit(c: Char) = c in '0'..'9'