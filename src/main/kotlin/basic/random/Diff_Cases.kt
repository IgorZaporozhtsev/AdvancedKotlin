package main.lambda.operations

import main.data.getData

fun main() {
    val heroes = getData()
    heroes.groupBy { it.name }
        .mapValues {
            it.value.reduce { acc, hero -> acc.copy(age = acc.age + hero.age) } }
        .values
}