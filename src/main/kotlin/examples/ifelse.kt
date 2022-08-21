package examples


fun main() {

    val event = EventContext(1, 0, "HELLO")

    val contexts = mutableListOf<EventContext>(event)

    contexts.forEach {

        if (sessionPredicate(it)){
            println()
        }
        else {
            println()
        }
    }




    val who = "rak"
    val _where = "na gore"
    val what = "swistnet"

    val rak = { who == "rak" }
    val naGore = { _where == "na gore" }
    val swistnet = { what == "swistnet" }

    val workPredicate = listOf(rak, naGore, swistnet).all { it() }
    if (workPredicate == true) {
        println("It is happened")
    } else {
        println("Wait for it...")
    }

}

fun sessionPredicate(context: EventContext): Boolean = context.type == "HELLO"

data class EventContext(val id: Int, val b: Int, val type: String)
