package main.interfaces

import main.classes.Person8

fun main(){
    val provider = BasicInfoProvider2()
    provider.printDetails(Person8())
}

interface PersonInfoProvider2{
    fun printDetails(person: Person8) {
        person.printInfo()
    }
}

class BasicInfoProvider2 : PersonInfoProvider2 {

}
