package data_structure.linked_list

class LinkedList<T: Any> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

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

