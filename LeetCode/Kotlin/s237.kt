class Solution237 {
    fun deleteNode(node: ListNode?) {
        node?.apply {
            this.`val` = node.next?.`val`!!
            this.next = node.next?.next
        }
    }
}

