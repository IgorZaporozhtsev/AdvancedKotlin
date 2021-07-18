package main.object_features

fun main() {

    var c: Char = "abc".lastChar();
    println(c)
}

//fun String.lastChar() = this.get(this.length - 1)
fun String.lastChar() = get(this.length - 1)