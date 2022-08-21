package examples

fun main() {

    val map = mutableMapOf<String, String>()
    val map2 = mutableMapOf<Sam, String>()

    val sam = Sam(null)
    val list = listOf(null).joinToString ("-" )


    println(list)

    map.put("hello", "first");
    map.put("hi", "scond");
    map.put("hello", "third");
    map.put(list, "fifth");
    map.put(list, "sisth");


    map2.put(sam, "fourth");

    map.forEach { (key, value) -> println("$key ; $value") }
    //map2.forEach { (key, value) -> println("$key = $value") }
}


data class Sam(val name: String?)