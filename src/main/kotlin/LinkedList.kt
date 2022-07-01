

class LinkedList<T> : Iterable<T>{

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0
        private set

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun push(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    fun append(value: T) {
        // 1
        if (isEmpty()) {
            push(value)
            return
        }
        // 2
        tail?.next = Node(value = value)

        // 3
        tail = tail?.next
        size++
    }

    fun findNode(index: Int): Node<T>? {
        // 1
        var currentNode = head
        var currentIndex = 0

        // 2
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        // 1
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        // 2
        val newNode = Node(value = value, next = afterNode.next)
        // 3
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty()) {
            tail = null
        }

        return result
    }

    fun removeLast(): T? {
        // 1
        val head = head ?: return null
        // 2
        if (head.next == null) return pop()
        // 3
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

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }
}

class LinkedListIterator<T>(
    private val list: LinkedList<T>
) : Iterator<T> {
    private var lastNode: Node<T>? = null
    private var index = 0

    override fun next(): T {
        // 1
        if (index >= list.size) throw IndexOutOfBoundsException()
        // 2
        lastNode = if (index == 0) {
            list.findNode(0)
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

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

fun main() {
    println("-----------------       Node         ----------------------")
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)

    node1.next = node2
    node2.next = node3

    println(node1)

    // Push Example
    println("-----------------       Push         ----------------------")
    val list = LinkedList<Int>()
    list.push(3)
    list.push(2)
    list.push(1)

    println(list)

    // Append Example
    println("-----------------       Append         ----------------------")
    val list1 = LinkedList<Int>()
    list1.append(1)
    list1.append(2)
    list1.append(3)

    println(list1)

    // Find and insert
    println("-----------------       Insert         ----------------------")
    val list2 = LinkedList<Int>()
    list2.push(3)
    list2.push(2)
    list2.push(1)

    println("Before inserting: $list2")
    var middleNode = list2.findNode(1)!!
    for (i in 1..3) {
        middleNode = list2.insert(-1 * i, middleNode)
    }
    println("After inserting: $list2")

    // Insert and pop
    println("-----------------       POP         ----------------------")
    val list3 = LinkedList<Int>()
    list3.push(3)
    list3.push(2)
    list3.push(1)

    println("Before popping list: $list3")
    val poppedValue = list3.pop()
    println("After popping list: $list3")
    println("Popped value: $poppedValue")


    // Remove Last
    println("-----------------       Remove Last         ----------------------")
    val list4 = LinkedList<Int>()
    list4.push(3)
    list4.push(2)
    list4.push(1)

    println("Before removing last node: $list4")
    val removedValue = list4.removeLast()

    println("After removing last node: $list4")
    println("Removed value: $removedValue")

    // Remove After
    println("-----------------       Remove After         ----------------------")
    val list5 = LinkedList<Int>()
    list5.push(3)
    list5.push(2)
    list5.push(1)

    println("Before removing at particular index: $list5")
    val index = 1
    val node = list5.findNode(index - 1)!!
    val removedValue1 = list5.removeAfter(node)

    println("After removing at index $index: $list5")
    println("Removed value: $removedValue")

    // Iterable
    println("-----------------       Iterable         ----------------------")
    val list6 = LinkedList<Int>()
    list6.push(3)
    list6.push(2)
    list6.push(1)
    println(list6)

    for (item in list6) {
        println("Double: ${item * 2}")
    }
}