package data_structure.linked_list

class LinkedList<T : Any> : Iterable<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0
    private set

    fun push(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    fun chainPush(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T){
        if (isEmpty()){
            push(value)
            return
        }
        tail?.next = Node(value = value)
        tail = tail?.next
        size++
    }

    fun chainAppend(value: T): LinkedList<T> {
        if (isEmpty()){
            push(value)
            return this
        }
        tail?.next = Node(value = value)
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>?{
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T>{
        if (tail == afterNode){
            append(value)
            return tail!!
        }

        val newNode = Node(value = value, next = afterNode.next)

        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T?{
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty()){
            tail = null
        }
        return result
    }

    fun removeLast(): T? {

        //if head == null is not makes sense continue
        val head = head ?: return null

        //if head consist of only one node we use pop that retrieve node from front
        if (head.next == null) return pop()

        size--

        // 4
        var prev = head
        var current = head

        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        // 5
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result
    }

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }

    private fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()){
            "Empty List"
        } else {
            head.toString()
        }
    }


}

