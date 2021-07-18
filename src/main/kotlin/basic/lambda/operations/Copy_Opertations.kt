package main.lambda.operations

import main.data.getData

fun main() {
    val heroes = getData()
    val result = heroes.map { it.copy(name = "Admiral") }
    println(result.joinToString(separator = "\n"))

}