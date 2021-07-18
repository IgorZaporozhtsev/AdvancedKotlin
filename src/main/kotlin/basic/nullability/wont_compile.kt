package main.nullability


class Name(val value: String) {
}

//fun isFoo1(n: Name) = n.value == "foo" //not compile
//fun isFoo2(n: Name?) = n.value == "foo" //not compile
fun isFoo3(n: Name?) = n != null && n.value == "foo"
fun isFoo4(n: Name?) = n?.value == "foo"

fun main() {
    //isFoo1(null) //not compile
    //isFoo2(null) //not compile
    isFoo3(null)
    isFoo4(null)
}


