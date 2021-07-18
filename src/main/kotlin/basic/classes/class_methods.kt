package main.classes


fun main(){
    val person8 = Person8()
    person8.printInfo()
}

// getter/setter
class Person8 (var firstName: String = "Peter", var lastName:String = "Parker") {
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

    fun printInfo(){
        //val nickNameToPrint = if(nickName != null) nickName else "no nickname"
        val nickNameToPrint = nickName ?: "no nickname" // ? - elvis operator
        println("$firstName ($nickNameToPrint) $lastName")
    }
}

