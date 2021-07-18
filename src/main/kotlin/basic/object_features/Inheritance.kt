package main.object_features

import main.classes.Person8

//by default classes closed they are final
// we should add open key word to the class

class FancyInfoProvider : BasicInfoProvider5(){

    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override val providerInfo: String
        get() = "Fancy info provider"

    override fun printDetails(person: Person8) {
        super.printDetails(person)
        println("Fancy Info")

    }


}