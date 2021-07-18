package main.member_references

import main.lambda.Hero

fun main() {
    //example 1
    val action = { hero: Hero, message:String -> sendEmail(hero, message) }
    val action2 = ::sendEmail

    //example 2

    val  list = listOf(1,2,3,4)
    list.any(::isEven) //true
    list.filter(::isEven) // [2, 4]

}

fun sendEmail(hero: Hero, message: String) {
    print("$hero said $message")
}

fun isEven(i: Int): Boolean = i % 2 == 0;
