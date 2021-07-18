package main.interfaces

import main.classes.Person8

fun main(){
    val provider = BasicInfoProvider4()
    provider.printDetails(Person8())
    provider.getSessionId()
}

interface PersonInfoProvider4{

    //properties
    val providerInfo: String

    fun printDetails(person: Person8) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider1{
    fun getSessionId() : String
}

class BasicInfoProvider4 : PersonInfoProvider4, SessionInfoProvider1 {
    override val providerInfo: String
        get() = "Basic Info provider"

    //we can override and use properties inside interface
    override fun printDetails(person: Person8) {
        super.printDetails(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return "sessionId"
    }
}