package examples

fun main() {
    val rank = getListTriple()?.apply {
        if (this.isNotEmpty()) saveData(Data( this))
    }

}

fun getListTriple(): List<Triple<String, String, String>>?{
    //return null
    //return listOf()
    return listOf(Triple("d","d","d"))
}

fun saveData(data: Data){
    println(data)
}

data class Data(
    val triple: List<Triple<String, String, String>>?
)


inline fun <E: Any, T: Collection<E>> T?.withNullOrEmpty(func: () -> Unit): Unit {
    if (this == null || this.isEmpty()) {
        func()
    }
}