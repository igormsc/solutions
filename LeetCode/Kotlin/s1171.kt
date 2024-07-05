class Solution1171 {
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        val root = ListNode(0).also { it.next = head }
        val m = mutableMapOf(0 to root)
        var s = 0
        var node = head
        while (node != null) {
            s += node.`val`
            if (m.contains(s)) {
                var prev = m[s]
                val start = prev
                var x = s
                while (prev != node) {
                    prev = prev!!.next
                    x += prev!!.`val`
                    if (prev != node) m.remove(x)
                }
                start!!.next = node.next
            } else m[s] = node
            node = node.next
        }
        return root.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
