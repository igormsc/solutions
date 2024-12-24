class MyLinkedList() {
    private var size = 0
    private var head: Node? = Node(0)

    fun get(index: Int): Int =
        if (index >= size) -1 else {
            var t = head?.next
            (0..<index).forEach { t = t?.next }
            t!!.v
        }


    fun addAtHead(`val`: Int) {
        var t = head?.next
        head?.next = Node(`val`)
        head!!.next?.next = t
        size++
    }

    fun addAtTail(`val`: Int) {
        var t = head
        while (t?.next != null) t = t.next
        t!!.next = Node(`val`)
        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index> size) return
        var t = head
        (0..<index).forEach { t = t?.next}
        val t1 = t?.next
        t?.next = Node(`val`)
        t!!.next?.next = t1
        size++
    }

    fun deleteAtIndex(index: Int) {
        if (index >= size) return
        var t = head
        (0..<index).forEach { t = t?.next}
        var t1 = t?.next
        t?.next = t1?.next
        t1?.next = null
        size--
        t1 = null
    }

    internal class Node(var v: Int) {
        var next: Node? = null
    }

}
