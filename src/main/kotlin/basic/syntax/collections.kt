package main.syntax

fun greetings(greeting:String, names:List<String>) {
    names.forEach {
        name -> println("$greeting $name")
    }
}


fun main(){
    val names = listOf("Peter", "James", "Em")
    greetings("Hi", names)

}