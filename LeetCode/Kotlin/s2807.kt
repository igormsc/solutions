class Solution2807 {
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var n = head
        while (n?.next != null) {
            val x = ListNode(gcd(n.`val`, n.next!!.`val`))
            x.next = n.next
            n.next = x
            n = n.next!!.next
        }
        return head
    }

    private fun gcd(a: Int, b: Int):Int = if (b==0) a else gcd(b,a%b)
}
