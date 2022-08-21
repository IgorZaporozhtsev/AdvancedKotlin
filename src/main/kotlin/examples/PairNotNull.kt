package examples

fun main() {

    val pair = null to null

    val notEmpty = pair.toList().isNotEmpty()
    println(notEmpty)
}