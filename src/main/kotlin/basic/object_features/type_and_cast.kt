package main.object_features

import main.classes.Person8

fun main(){
    //val provider = BasicInfoProvider5()
    val provider = FancyInfoProvider()

    provider.printDetails(Person8())
    provider.getSessionId()
    checkTypes(provider)
}

interface PersonInfoProvider5{

    //properties
    val providerInfo: String

    fun printDetails(person: Person8) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider2{
    fun getSessionId() : String
}

open class BasicInfoProvider5 : PersonInfoProvider5, SessionInfoProvider2 {
    override val providerInfo: String
        get() = "Basic Info provider"

    protected open val sessionIdPrefix = "sessionIdPrefix"

    //we can override and use properties inside interface
    override fun printDetails(person: Person8) {
        super.printDetails(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

//check if it is instance of
fun checkTypes(infoProvider5: PersonInfoProvider5){
    if (infoProvider5 is SessionInfoProvider2){     //  !is
        println("yes, is a session info provider")
        //casting
        //(infoProvider5 as SessionInfoProvider2).getSessionId() // we don'r need explicitly check, compiler do smart check
        infoProvider5.getSessionId()
    } else{
        println("yes, is a session info provider")
    }
}