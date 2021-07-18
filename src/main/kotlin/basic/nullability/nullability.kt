package main.nullability

//make NPE compile-time error not run-time error
fun main() {
    val s: String? = "abc"

    val len1 = if (s != null) s.length else 0


    //or

    //val length: Int = s?.length //wrong Int type of length
    val length: Int? = s?.length //proper type Int? of length

    val length2: Int = s?.length ?: 0 //length2 can be not nullable type because of default value in else (?:) section


}