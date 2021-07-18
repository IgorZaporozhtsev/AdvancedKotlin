package main.interfaces

import main.classes.Person8

fun main(){
 val provider = BasicInfoProvider()
    provider.printDetails(Person8())
}

interface PersonInfoProvider{
    fun printDetails(person: Person8)
}

class BasicInfoProvider : PersonInfoProvider {
    override fun printDetails(person: Person8) {
        person.printInfo()
    }
}


