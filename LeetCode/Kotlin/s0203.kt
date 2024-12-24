class Solution203 {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var head = head
        while (head != null && head.`val` == `val`) head = head.next
        var cur = head
        while (cur?.next != null) {
            if (cur.next!!.`val` == `val`) cur.next = cur.next!!.next else cur = cur.next
        }
        return head
    }
}
