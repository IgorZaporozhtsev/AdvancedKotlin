package main


class Person (var firstName: String, var lastName:String) // это класс с полями

fun main2() {

    var person = Person("Peter", "Parker")     //это инстанс обьета
    getBalanceOfPerson(person, balance = 23L)

}

fun getBalanceOfPerson (person: Person, balance: Long){

    person.firstName = "Sam"

    findName(person)

    saveToDataBase(person) //какое имя у обьекта Person сораниться в БД?

}

fun findName(person: Person) : Person{

    person.firstName = "Tony"

    return person;
}

fun saveToDataBase(person: Person){
    val list = mutableListOf<Person>()
    list.add(person)
}