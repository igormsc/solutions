class Solution445 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2
        val s1 = mutableListOf<Int>()
        val s2 = mutableListOf<Int>()
        while (l1 != null) {
            s1.add(l1.`val`)
            l1 = l1.next
        }
        while (l2 != null) {
            s2.add(l2.`val`)
            l2 = l2.next
        }
        var sum = 0
        var list = ListNode(0)
        while (s1.isNotEmpty() || s2.isNotEmpty()) {
            if (s1.isNotEmpty())
                sum += s1.removeLast()
            if (s2.isNotEmpty())
                sum += s2.removeLast()
            list.`val` = sum % 10
            val head = ListNode(sum / 10)
            head.next = list
            list = head
            sum /= 10
        }

        return if (list.`val` == 0) list.next else list
    }
}
