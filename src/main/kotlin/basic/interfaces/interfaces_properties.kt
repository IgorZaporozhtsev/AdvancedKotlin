package main.interfaces

import main.classes.Person8

fun main(){
    val provider = BasicInfoProvider3()
    provider.printDetails(Person8())
}

interface PersonInfoProvider3{

    //properties
    val providerInfo: String

    fun printDetails(person: Person8) {
        println(providerInfo)
        person.printInfo()
    }
}

class BasicInfoProvider3 : PersonInfoProvider3 {
    override val providerInfo: String
    get() = "Basic Info provider"

    //we can override and use properties inside interface
    override fun printDetails(person: Person8) {
        super.printDetails(person)
        println("additional print statement")
    }
}
