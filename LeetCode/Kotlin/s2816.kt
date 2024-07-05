class Solution2816 {
    fun doubleIt(head: ListNode?): ListNode? {
        val head = if (head != null && head.`val` > 4) ListNode(0).also { it.next = head } else head
        var node = head
        while (node != null) {
            node.`val` = (node.`val`*2)%10
            if (node.next != null && node.next!!.`val` > 4) node.`val`++
            node = node.next
        }
        return head
    }
}

