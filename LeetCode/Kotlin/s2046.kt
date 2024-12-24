class Solution2046 {
    fun sortLinkedList(head: ListNode?): ListNode? {
        var (head, prev) = head to head
        var cur = head?.next
        while (cur != null) {
            if (cur.`val` < 0) {
                val t = cur.next
                prev?.next = t
                cur.next = head
                head = cur
                cur = t
            } else {
                prev = cur
                cur = cur.next
            }
        }
        return head
    }

}