class Solution1474 {
    fun deleteNodes(head: ListNode?, m: Int, n: Int): ListNode? {
        var pre = head
        while (pre != null) {
            run {
                var i = 0
                while (i < m - 1 && pre != null) {
                    pre = pre!!.next
                    i++
                }
            }
            if (pre == null) return head
            var cur = pre
            var i = 0
            while (i < n && cur != null) {
                cur = cur.next
                i++
            }
            pre!!.next = cur?.next
            pre = pre!!.next
        }
        return head
    }

}