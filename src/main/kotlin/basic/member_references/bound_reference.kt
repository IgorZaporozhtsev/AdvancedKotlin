package main.member_references

fun main() {
    val alice = Person("Alice", 29)

        //Bound reference
    val agePredicate_first: (Person, Int) -> Boolean = { person, ageLimit -> person.isOlder(ageLimit)}

    val agePredicate_second = alice::isOlder // here Bound reference


    //here deference
    print(agePredicate_first(alice, 21))

    print(agePredicate_second(21))


    //this reference
    val predicate = alice.getAgePredicate()


}

class Person(val name:String, val age: Int){
    //method for example bound reference
    fun isOlder(ageLimit: Int) = age >  ageLimit
    //method for example this reference
    fun getAgePredicate() = this::isOlder //::isOlder
}


