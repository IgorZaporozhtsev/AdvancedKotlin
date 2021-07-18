package main.lambda

fun main() {
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

    val firstName = heroes.first().name
    println("firstName: $firstName")

    val lastName = heroes.last().name
    println("lastName: $lastName")

    val nameEqOrNull = heroes.firstOrNull { it.age == 30 }?.name
    println("nameEqThirtyOrNull: $nameEqOrNull")

    val countOfNotRepeatedAge = heroes.map { it.age }.distinct().size
    println("countOfNotRepeatedAge: $countOfNotRepeatedAge")

    val filterByAgeSize = heroes.filter { it.age < 30 }.size
    println("filterByAgeSize: $filterByAgeSize")

    val partition = heroes.partition { it.age > 30 }
    println("$partition\n")

    val (youngest, oldest) = heroes.partition { it.age > 30 }
    print("youngest: $youngest\n")
    print("oldest: $oldest\n")
    print("youngest.size: ${youngest.size}\n")
    print("oldest.size: ${oldest.size}\n")

    val hasMaxAgeSize = heroes.maxByOrNull { it.age }?.name
    println("hasMaxAgeSize: $hasMaxAgeSize")

    val whetherAllYoungerThenFifty = heroes.all { it.age > 50 }
    println("whetherAllYoungerThenFifty: $whetherAllYoungerThenFifty")

    val isAnyFemale = heroes.any { it.gender == Gender.FEMALE }
    println("anyFemale: $isAnyFemale")

    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxByOrNull { (_, group) -> group.size }!!
    println("age: $age - group: $group")

    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }
    val ageFr = mapByName["Frenchy"]?.age                      // null
    mapByName.getValue("Frenchy").age // throw
    println("$ageFr")


//    val keyOfSumResult =
//        heroes.associate { Pair(it.age, it) }.mapValues { Hero(it.value.name, it.value.age, it.value.gender) }

//    val heroesList  =
//        heroes.groupBy { it.name }.mapValues { it -> it.value.sumBy { it.age } }.entries

    val values = heroes.groupBy { it.name }
        .mapValues { it.value.reduce { acc, hero -> acc.copy(age = acc.age + hero.age) } }.values

//    val unknownHero = Hero("Unknown", 0, null)
//    keyOfSumResult.getOrElse("unknown") { unknownHero }
}

public inline fun <T, K> Grouping<T, K>.sumBy(
    selector: (T) -> Int
): Map<K, Int> =
    fold(0) { acc, element -> acc + selector(element) }
