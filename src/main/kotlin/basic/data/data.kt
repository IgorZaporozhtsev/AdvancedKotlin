package main.data

import main.lambda.Gender
import main.lambda.Hero

fun getData(): List<Hero>{

    val heroes = listOf(
        Hero("The Captain", 10, Gender.MALE),
        Hero("The Captain", 25, Gender.MALE),
        Hero("The Captain", 5, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 11, Gender.FEMALE),
        Hero("Lady Lauren", 11, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.FEMALE)
    )

    return heroes
}