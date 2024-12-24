class Solution1836 {
    fun deleteDuplicatesUnsorted(head: ListNode?): ListNode? {
        val cnt = mutableMapOf<Int, Int>()
        run {
            var cur = head
            while (cur != null) {
                cnt[cur!!.`val`] = (cnt[cur!!.`val`]?:0) + 1
                cur = cur!!.next
            }
        }
        val dummy = ListNode(0, head)
        var pre = dummy
        var cur = head
        while (cur != null) {
            if (cnt[cur!!.`val`]!! > 1) pre.next = cur!!.next
            else pre = cur!!
            cur = cur!!.next
        }
        return dummy.next
    }

}