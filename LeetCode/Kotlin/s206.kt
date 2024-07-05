class Solution206 {
    fun reverseList(head: ListNode?): ListNode? {
        var reverse: ListNode? = null
        var node = head
        while (node != null) reverse = node.also { node?.next = reverse.also { node = node?.next } }
        return reverse
    }
}

