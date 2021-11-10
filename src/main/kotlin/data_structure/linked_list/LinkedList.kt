package data_structure.linked_list

class LinkedList<T> : Collection<T>, MutableIterable<T>, MutableCollection<T>  {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
    private set
//Adds a value at the front of the list.
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

    // Adds a value at the end of the list.
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
    /**
    * @see #nodeAt tries to retrieve a node in the list based on the given index.
    *
    * */
    fun nodeAt(index: Int): Node<T>?{
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }
//Adds a value after a particular node of the list
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

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched)) return false
        }
        return true
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()){
            "Empty List"
        } else {
            head.toString()
        }
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements){
            append(element)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        //1
        val iterator = iterator()
        //2
        while (iterator.hasNext()){
            val item = iterator.next()
            //3
            if (item == element){
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements){
            result = remove(item) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()){
            val item = iterator.next()
            if (!elements.contains(item)){
                iterator.remove()
                result = true
            }
        }
        return result
    }



}

