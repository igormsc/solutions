
class Solution002 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2
        var carry = 0
        val dummy = ListNode(0)
        var cur: ListNode? = dummy
        while (l1 != null || l2 != null || carry != 0) {
            val s = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
            carry = s / 10
            cur!!.next = ListNode(s % 10)
            cur = cur.next
            l1 = l1?.next
            l2 = l2?.next
        }
        return dummy.next
    }
}

class ListNode(var `val`: Int) {
     var next: ListNode? = null
}

