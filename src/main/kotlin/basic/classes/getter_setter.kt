package main.classes

fun main(){
    val person7 = Person8()
    person7.nickName = "Spiderman"
    person7.nickName = "Black SpiderMan"

    println(person7.nickName)
}

// getter/setter
class Person7 ( var firstName: String = "Peter", var lastName:String = "Parker") {
    // var has getter and setter
    // val has getter
    var nickName: String? = null

        set(value) {
            field = value
            println("the new nickname is $value")
        }

        get() {
            println("the returned value is $field")
            return field;
        }
}