package main.classes

fun main(){
    //val person = Person3("Peter", "Peterson")
    //val person4 = Person4()
    //val person5 = Person5()
    val person6 = Person6()
    person6.nickName = "Spiderman"

}

//approach 6
class Person6 ( var firstName: String = "Peter", var lastName:String = "Parker") {
    var nickName: String? = null
}

//approach 5 for constructor with default values
class Person5 ( var firstName: String = "Peter", var lastName:String = "Parker") {

}

//approach 4 for constructor
class Person4 ( var firstName: String, var lastName:String) {

    init {
        println("init 1")
    }

    constructor(): this("Peter", "Parker"){
        println("Secondary constructor")
    }

    init {
        println("init 2")
    }
}

//approach 3 for constructor
class Person3 ( var firstName: String, var lastName:String) {

}

//approach 2 for constructor
class Person2 ( _firstName: String, _lastName:String) {

    val lastName: String = _lastName //short form of init block
    val firstName: String = _firstName //short form of init block
}

//approach 1 for constructor
class Person1 ( _firstName: String, _lastName:String) {

    val firstName: String
    val lastName: String
    init {
        firstName = _firstName
        lastName = _lastName
    }

}

class User constructor() //explicitly define constructor






