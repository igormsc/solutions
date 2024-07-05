class Solution2487 {
    fun removeNodes(head: ListNode?): ListNode? {
        val tmp = ListNode(Int.MAX_VALUE)
        val st = mutableListOf(tmp)
        var p = head
        while (p != null) {
            while (st.last().`val` < p.`val`) st.removeLast()
            st.last().next = p
            st.add(p)
            p = p.next
        }
        return tmp.next
    }
}
