import java.util.*

class MaxStack() {

    class Node {
        var `val`: Int = 0
        var prev: Node? = null
        var next: Node? = null

        constructor()

        constructor(`val`: Int) {
            this.`val` = `val`
        }
    }

    class DoubleLinkedList {
        private val head = Node()
        private val tail = Node()

        init {
            head.next = tail
            tail.prev = head
        }

        fun append(`val`: Int): Node {
            val node = Node(`val`)
            node.next = tail
            node.prev = tail.prev
            tail.prev = node
            node.prev?.next = node
            return node
        }

        fun pop(): Node {
            return remove(tail.prev!!)
        }

        fun peek(): Int = tail.prev!!.`val`

        companion object {
            fun remove(node: Node): Node {
                node.prev?.next = node.next
                node.next?.prev = node.prev
                return node
            }
        }
    }

    private val stk = DoubleLinkedList()
    private val tm = TreeMap<Int, MutableList<Node>>()

    fun push(x: Int) {
        val node = stk.append(x)
        tm.computeIfAbsent(x) { mutableListOf() }.add(node)
    }

    fun pop(): Int {
        val node = stk.pop()
        val nodes = tm[node.`val`]!!
        val x = nodes.removeLast().`val`
        if (nodes.isEmpty()) tm.remove(node.`val`)
        return x
    }

    fun top(): Int = stk.peek()

    fun peekMax(): Int = tm.lastKey()

    fun popMax(): Int {
        val x = peekMax()
        val nodes = tm[x]!!
        val node = nodes.removeLast()
        if (nodes.isEmpty()) tm.remove(x)
        DoubleLinkedList.remove(node)
        return x
    }
}


