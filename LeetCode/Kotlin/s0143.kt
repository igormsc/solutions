class Solution143 {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return
        var (slow ,fast) = head as ListNode? to head as ListNode?
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        val (preMid, preCur) = slow to slow?.next
        while (preCur?.next != null) preCur.next = preCur.next?.next.also { preCur.next?.next = preMid?.next.also { preMid?.next = preCur.next } }
        slow = head
        fast = preMid?.next
        while (slow != preMid) {
            preMid?.next = fast?.next
            fast?.next = slow?.next
            slow?.next = fast
            slow = fast?.next
            fast = preMid?.next
        }
    }


}
