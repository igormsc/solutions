class Solution2674 {
    fun splitCircularLinkedList(list: ListNode?): Array<ListNode?> {
        var a: ListNode? = list
        var b: ListNode? = list
        while (b!!.next != list && b.next!!.next != list) {
            a = a!!.next
            b = b.next!!.next
        }
        if (b.next != list) b = b.next
        val list2 = a!!.next
        b!!.next = list2
        a.next = list
        return arrayOf(list, list2)
    }

}