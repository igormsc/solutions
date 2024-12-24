class Solution234 {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        slow?.next = reverse(slow?.next)
        slow = slow?.next
        var node = head
        while (slow != null) {
            if (node!!.`val` != slow.`val`) return false
            node = node.next
            slow = slow.next
        }
        return true
    }

    private fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var next: ListNode? = null
        var head = head
        while (head != null) {
            next = head.next
            head.next = prev
            prev = head
            head = next
        }
        return prev
    }

}
