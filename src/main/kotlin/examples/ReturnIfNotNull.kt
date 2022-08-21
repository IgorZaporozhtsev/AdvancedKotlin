package examples


fun main() {

    println(invalidate())

}



fun invalidate(): List<Int?> {
    val cacheOfferingTraversal = null
    val cacheRates = 43

    val list = listOf<Int?>(
        cacheOfferingTraversal, cacheRates
    )
    if (list.all { it == null }) throw IllegalArgumentException("it")

    if (list.isEmpty()) throw IllegalArgumentException("it")
    return list



}