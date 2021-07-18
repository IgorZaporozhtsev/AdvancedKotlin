package main.syntax



fun main(){

    //1
    val things = listOf("zero", "one", "two")
    things.forEach { thing -> println(thing) }

    //2
    val map = mapOf("one" to "first_name", "two" to "last_name")
    map.forEach {(key, value) -> println("$key -> $value")}

    //3
    val cars = mutableListOf("VW", "VOLVO")
    cars.add("Polo")

    cars.forEach {car -> println(car)}
    //4
    val carsMap = mutableMapOf("VW" to "Polo", "VW" to "Golf")
    carsMap.putIfAbsent("VW", "Jetta");

    //5 contains
    if ("two" in things) println(true)

}