package examples

sealed class Result
data class SuccessResult(val value: Int): Result()
data class ExceptionResult(val exception: Exception): Result()

val a = 10
val b = 20
val sum = when (val result = calculateSum(a,b)) {
    is SuccessResult -> result.value
    is ExceptionResult -> {
        result.exception.printStackTrace()
        -1
    }
}

fun calculateSum(a: Int, b: Int): Result {
   val value = a - b
    return if (value > 1) {
        SuccessResult(value)
    } else {
        ExceptionResult(java.lang.Exception("shouldn't be less the one"))
    }
}


fun main() {
    println(sum)

}

