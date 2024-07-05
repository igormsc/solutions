class Solution1669 {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        val start = (0..<a-1).fold(list1) { n, _ -> n!!.next }
        val end = (0..<b).fold(list1) { n, _ -> n!!.next}
        var node = list2
        start!!.next = node
        while (node?.next != null) node = node.next
        node?.next = end!!.next
        return list1
    }
}
