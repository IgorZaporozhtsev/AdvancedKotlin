package design_patterns

import org.junit.jupiter.api.Test

class Strategy {

    val lowerCaseFormatter: (String) -> String = { it.lowercase() }
    val upperCaseFormatter = { it: String -> it.uppercase() }

    @Test
    fun Strategy() {

        val inputString = "LOREM ipsum DOLOR sit amet"

        val lowerCasePrinter = Printer(lowerCaseFormatter)
        lowerCasePrinter.printString(inputString)

        val upperCasePrinter = Printer(upperCaseFormatter)
        upperCasePrinter.printString(inputString)

        val prefixPrinter = Printer { "Prefix: $it" }
        prefixPrinter.printString(inputString)
    }
}