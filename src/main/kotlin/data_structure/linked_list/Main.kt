package data_structure.linked_list

fun main() {
    "creating and linking nodes" example {
        val node1 = Node(value = 1)
        val node2 = Node(value = 2)
        val node3 = Node(value = 3)

        node1.next = node2
        node2.next = node3

        println(node1)
    }

    "push" example {
        val list = LinkedList<Int>()
        list.push(23)
        list.push(52)
        list.push(4)

        println(list)
    }

    "fluent interface push" example {
        val list = LinkedList<Int>()
        list.chainPush(1017)
            .chainPush(57)
            .chainPush(523)
        println(list)
    }

    "append" example {
        val list = LinkedList<Int>()
        list.append(42)
        list.append(721)
        list.append(13)

        println(list)
    }

    "fluent interface append" example {
        val list = LinkedList<Int>()
        list.chainAppend(5)
        list.chainAppend(21)
        list.chainAppend(19)

        println(list)
    }
    "inserting at a particular index" example {
        val list = LinkedList<String>()
        list.push("Mouse")
        list.push("Alligator")
        list.push("Lyon")

        println("Before inserting: $list")
        val middleNode = list.nodeAt(1)!!
        list.insert("Cat", middleNode)
        list.insert("Dog", middleNode)

        println("After inserting: $list")
    }

    "pop" example {
        val list = LinkedList<String>()
        list.push("sure")
        list.push("pretty")
        list.push("I'm")

        println("Before popping list: $list \n list size: ${list.size}")
        val poppedValue = list.pop()
        println("After popping list: $list and \n list size: ${list.size}")
        println("Popped value: $poppedValue")
    }

    "pop if one" example {
        val list = LinkedList<String>()
        list.push("One")

        println("Before popping list: $list \n list size: ${list.size}")
        val poppedValue = list.pop()
        println("After popping list: $list and \n list size: ${list.size}")
        println("Popped value: $poppedValue")
    }

    "removing the last node" example {
        val list = LinkedList<String>()
        list.push("One")
        list.push("Two")
        list.push("Three")
        list.push("Four")
        list.push("Five")
        list.push("Six")

        println("Before remove last node: $list \n list size: ${list.size}")
        val removedValue = list.removeLast()
        println("After remove last node: $list \n list size: ${list.size}")
        println("Removed value: $removedValue")
    }

    "removing a node after a particular node" example {
        val list = LinkedList<String>()
        list.push("Three")
        list.push("Two")
        list.push("One")

        println("Before removing at particular index: $list")
        val index = 1
        val node = list.nodeAt(index - 1)!!
        val removedValue = list.removeAfter(node)

        println("After removing at index $index: $list")
        println("Removed value: $removedValue")
    }
}

private infix fun String.example(function: () -> Unit) {
    println("Example of $this \n")
    println("OUTPUT:")
    function()
    println("\n")
}
