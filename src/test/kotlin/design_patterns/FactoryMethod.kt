package design_patterns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

sealed class Country {
    object USA : Country() //Kotlin 1.0 could only be an inner class or object
}

object Spain : Country() //object позволяет одновременно объявить класс и создать его экземпляр

class Greece(val someProperty: String) : Country()

class Poland(val someProperty: String) : Country()

object Ukraine : Country()

data class Canada(val someProperty: String) : Country() //Kotlin 1.1 data class extends other class
//object Poland : Country()

class Currency(
    val code: String
)

object CurrencyFactory {

    fun currencyForCountry(country: Country): Currency =
        when (country) {
            is Greece -> Currency("EUR")
            is Spain -> Currency("EUR")
            is Country.USA -> Currency("USD")
            is Canada -> Currency("CAD")
            is Poland -> Currency("ZL")
            is Ukraine -> Currency("GRV")
        }  //try to add a new country Poland, it won't even compile without adding new branch to 'when'
}

class FactoryMethodTest {

    @Test
    fun FactoryMethod() {
        val ukraineCurrency = CurrencyFactory.currencyForCountry(Ukraine).code
        println("Ukraine currency: $ukraineCurrency")

        val polandCurrency = CurrencyFactory.currencyForCountry(Poland("PL")).code
        println("Poland currency: $polandCurrency")

        val greeceCurrency = CurrencyFactory.currencyForCountry(Greece("")).code
        println("Greece currency: $greeceCurrency")

        val usaCurrency = CurrencyFactory.currencyForCountry(Country.USA).code
        println("USA currency: $usaCurrency")

        assertThat(greeceCurrency).isEqualTo("EUR")
        assertThat(usaCurrency).isEqualTo("USD")
        assertThat(polandCurrency).isEqualTo("ZL")
    }
}