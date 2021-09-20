package data_structure.linked_list

class LinkedListIterator<T>(
    private val list: LinkedList<T>,
    private var index: Int = 0,
    private var lastNode: Node<T>? = null
) : MutableIterator<T> {
    override fun next(): T {
        // 1
        if (index >= list.size) throw IndexOutOfBoundsException()
        // 2
        lastNode = if (index == 0) {
            list.nodeAt(0)
        } else {
            lastNode?.next
        }
        // 3
        index++
        return lastNode!!.value
    }
    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun remove() {
        // 1
        if (index == 1) {
            list.pop()
        } else {
            // 2
            val prevNode = list.nodeAt(index - 2) ?: return
            // 3
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
        index--
    }
}
