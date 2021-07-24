package basic.scope_functions

data class Citizen(val name: String, val age: Int, val residence: String)

fun main() {
    val citizen1:Citizen? = Citizen(name = "Hans", age = 23, residence = "Washington")
    val citizen2 = Citizen(name = "Nick", age = 65, residence = "Boston")

    /**
     * RUN
     * return: anything
     * access: this, directly
     *
     * */

    val total: Int? = citizen1?.run {
        println("T.run - ${this.age} - $age")
        this.name.length + age + this.residence.length
    }

    println("return value of RUN: $total")/**

     * LET
     * return: anything
     * access: it
     *
     * */

    val total2: Int = citizen1?.let {
        println("T.let - ${it.age}")
        it.name.length + it.age + it.residence.length
    }?: -1

    println("return value of LET: $total2")


}