class Solution3062 {
    fun gameResult(head: ListNode?): String {
        var n = head
        var (odd, even) = 0 to 0
        while (n != null) {
            val a = n.`val`
            val b = n.next!!.`val`
            if (a < b) odd++
            if (a > b) even++
            n = n.next!!.next
        }
        return when {
            odd > even -> "Odd"
            odd < even -> "Even"
            else -> "Tie"
        }
    }
}