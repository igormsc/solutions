class Solution369 {
    fun plusOne(head: ListNode?): ListNode? {
        var node = head
        val dummy = ListNode(0, node)
        var target: ListNode? = dummy
        while (node != null) {
            if (node.`val` != 9) target = node
            node = node.next
        }
        target!!.`val`++
        target = target.next
        while (target != null) {
            target.`val` = 0
            target = target.next
        }
        return if (dummy.`val` == 1) dummy else dummy.next
    }

}

class ListNode(var `val`: Int, var next: ListNode? = null)
