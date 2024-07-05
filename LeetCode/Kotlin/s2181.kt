class Solution2181 {
    fun mergeNodes(head: ListNode?): ListNode? {
        var tmp = head
        tmp = tmp?.next
        val res = ListNode(0)
        var tmp2 = res
        var sum = 0
        while (tmp != null) {
            if (tmp.`val` == 0) {
                tmp2.next = ListNode(sum)
                tmp2 = tmp2.next!!
                tmp = tmp.next
                sum = 0
            } else {
                sum += tmp.`val`
                tmp = tmp.next
            }
        }
        return res.next
    }

}
