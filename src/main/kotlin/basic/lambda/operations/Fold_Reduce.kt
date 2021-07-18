package main.lambda.operations

import main.data.getData
import main.lambda.Hero

fun main() {
    val heroes = getData()
    heroes.map { it.age }.also { print(it) }.fold(0) { acc, hero -> acc + hero * 2 }.also { print(it) }

    heroes.map { it.age }.also { print(it) }.reduce { acc, hero -> acc + hero * 2  }.also { print(it) }
}