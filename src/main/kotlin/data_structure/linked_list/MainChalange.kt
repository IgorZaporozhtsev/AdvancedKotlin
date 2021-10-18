package data_structure.linked_list


fun <T> LinkedList<T>.printInReverse() {
    this.nodeAt(0)?.printInReverse()
}

fun <T> Node<T>.printInReverse() {
    this.next?.printInReverse()
     //1
    if (this.next != null) {
        print(" -> ")
    }
    // 2
    print(this.value.toString())
}

fun <T> LinkedList<T>.getMiddle(): Node<T>? {
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }

    return slow
}

private fun <T> addInReverse(list: LinkedList<T>, node: Node<T>) {
    // 1
    val next = node.next
    if (next != null) {
        // 2
        addInReverse(list, next)
    }
    // 3
    list.append(node.value)
}

fun <T> LinkedList<T>.reversed(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}

fun <T> LinkedList<T>.ordered(): Node<T>? {
    TODO("not implemented")
}

fun main() {
    "reverse linked list" example {
        val list = LinkedList<String>()
        list.add("Mouse")
        list.add("Cat")
        list.add("Dog")

        list.printInReverse()
    }

    "print middle" example {
        val list = LinkedList<Int>()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)

        println(list)
        println(list.getMiddle()?.value)
    }

    "reverse list" example {
        val list = LinkedList<String>()
        list.add("Mouse")
        list.add("Cat")
        list.add("Dog")
        list.add("Crocodile")

        println("Original: $list")
        println("Reversed: ${list.reversed()}")
    }
}

private infix fun String.example(function: () -> Unit) {
    println("Example of $this \n")
    println("OUTPUT:")
    function()
    println("\n")
}