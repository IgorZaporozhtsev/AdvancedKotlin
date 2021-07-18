package main.examples

fun main() {
    val set = hashSetOf<Number>(1, 7, 53)
    val list = arrayListOf<Number>(1, 7, 53)
    val map = hashMapOf<Number, String>(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
}