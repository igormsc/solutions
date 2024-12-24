class Solution3063 {
    fun frequenciesOfElements(head: ListNode?): ListNode? {
        var head = head
        val cnt =  mutableMapOf<Int, Int>()
        while (head != null) {
            cnt.merge(head.`val`, 1) { a: Int, b: Int -> a+b }
            head = head.next
        }
        val dummy = ListNode(0)
        cnt.values.forEach{ dummy.next = ListNode(it, dummy.next) }
        return dummy.next
    }

}