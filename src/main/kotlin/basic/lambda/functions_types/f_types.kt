package main.lambda.functions_types

import main.lambda.Gender
import main.lambda.Hero

fun main() {
    val isEven = { i: Int -> i % 2 == 0 }

    val list = listOf(1, 2, 3, 4)

    val getEvenNumbers = list.any(isEven)

    val filterEvenNumbers = list.filter(isEven)

    print("even number from list: ${getEvenNumbers}\n")
    print("filter even numbers from list: ${filterEvenNumbers}\n")

    val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.FEMALE)
    )

    val isAgeOverThirty = { i: Int -> i > 30 }

    //benefit of this approach, you can use isAgeOverThirty expression in other functions
    val getAgeNotOverThirty = heroes.map { it.age }.filter(isAgeOverThirty)

    val getNamesWhichAgeNotOverThirty = heroes.filter { it.age > 30 }.map { it.name }.toList()

    print("Ages Not Over Thirty: ${getAgeNotOverThirty}\n")
    print("Names Which Age Not Over Thirty: ${getNamesWhichAgeNotOverThirty}\n")
}