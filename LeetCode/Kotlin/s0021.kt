class Solution021 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(Int.MIN_VALUE)
        var tail:ListNode? = dummy
        var list1 = list1
        var list2 = list2

        while (list1 != null && list2 != null) {
            if (list1.`val` < list2.`val`) tail?.next = list1.also{list1 = list1?.next}
            else tail?.next = list2.also{list2 = list2?.next}
            tail = tail?.next
        }
        tail?.next = if (list1 != null) list1 else list2
        return dummy.next
    }
}
