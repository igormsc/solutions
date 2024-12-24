class Solution3217 {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val set = nums.toSet()
        val dummy = ListNode(0)
        var curr = dummy
        var node = head
        while (node != null) {
            if (!set.contains(node.`val`)) {
                curr.next = node
                curr = curr.next!!
            }
            node = node.next
        }
        curr.next = null
        return dummy.next
    }
}