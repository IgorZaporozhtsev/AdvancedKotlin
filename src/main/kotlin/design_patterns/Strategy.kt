package design_patterns

class Printer(
    private val stringFormatterStrategy: (String) -> String
) {

    fun printString(string: String) {
        println(stringFormatterStrategy(string))
    }
}