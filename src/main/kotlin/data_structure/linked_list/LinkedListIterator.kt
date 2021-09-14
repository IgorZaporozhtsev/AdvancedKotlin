package data_structure.linked_list

class LinkedListIterator<T>(
    private val list: LinkedList<T>,
    private var index: Int = 0,
    private var lastNode: Node<T>? = null
) : Iterator<T> {
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
}
