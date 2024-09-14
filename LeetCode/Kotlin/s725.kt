class Solution725 {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val nodes = Array<ListNode?>(k){null}
        if (head == null) return nodes
        var l = 0
        var n = head
        while (n != null) {
            l++
            n = n.next
        }
        var (pL, r) = l/k to l%k
        var ind = 0
        n = head
        while (n != null) {
            var res = n
            var j = if (r<=0) 0 else 1
            for (i in 0..<pL+j-1) n = n?.next
            n?.next = null.also {n = n?.next}
            nodes[ind++] = res
            r--
        }
        return nodes
    }
}