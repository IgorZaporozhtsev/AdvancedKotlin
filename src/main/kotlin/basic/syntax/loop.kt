package main.syntax

fun main(){

    var arrayOfThings = arrayOf("zero", "one", "two")
    println(arrayOfThings.size)

    //1
    println("#1")
    for (thing in arrayOfThings){
        println(thing)
    }

    //2
    println("#2")
    arrayOfThings.forEach {
        //it - is default name for each elem in the Array
        println(it)
    }

    //3
    println("#3")
    arrayOfThings.forEach { thing -> println(thing) }

    //4
    println("#4")
    arrayOfThings.forEachIndexed { index, elem -> println("$elem is at the $index index") }


    //5
    println("#5")
    for ((index, elem) in arrayOfThings.withIndex()){
        println("$index: $elem")
    }

    //6
    println("#6")
    val listOfThings = listOf("zero", "one", "two")
    listOfThings.forEach { thing -> println(thing) }

    //7
    println("#7")
    val names = mapOf("one" to "first_name", "two" to "last_name")
    names.forEach { (key, value) -> println("$key -> $value")}

    //8
    println("#8")
    for (i in 0..9){
        println(i)
    }

    //9
    println("#9")
    for (i in 1 until 9){
        println(i)
    }

    //10  //backward or over step
    println("#10")
    for (i in 9 downTo 1 step 2){
        println(i)
    }


    //11  iterate over string
    println("#11")
    for (ch in "abc"){
        println(ch + 1)
    }

    //12 iterate with last index
    println("#12")
    val arr = arrayOf("0","1","2","3","4","5","6")
    for (i in 0..arr.lastIndex){
        val info = arr[i].split("*")
        print(info)
    }

    //13 iterate with size
    println("#13")
    for (i in 0..arr.size){
        val info = arr[i].split("*")
        print(info)
    }

    //13 iterate with indices
    println("#`14")
    for (i in arr.indices){
        val info = arr[i].split("*")
        print(info)
    }



}