package main.syntax

fun greetings2(greeting:String, vararg names:String) { //vararg
    names.forEach {
        name -> println("$greeting $name")
    }
}


fun main(){
    val names = listOf("Peter", "James", "Em")

    //vararg
    greetings2("Hi", "Katy", "Joe")

    val names2 = arrayOf("Peter", "James", "Em")

    greetings2("Hi", *names2)


}