package design_patterns

//data class Person(var name: String, var age: Int, var city: String) {
//    fun moveTo(newCity: String) { city = newCity }
//    fun incrementAge() { age++ }
//}
//
//fun main() {
//    val alice = Person("Alice", 20, "Amsterdam")
//    println(alice)
//    alice.moveTo("London")
//    alice.incrementAge()
//    println(alice)
//}

fun main() {
    val str = "Hello"
    // this
    str.run {
        println("Длина строки: $length")
        //println("Длина строки: ${this.length}") // делает то же самое
    }

    // it
    str.let {

        println("Длина строки: ${it.length}")
    }
}