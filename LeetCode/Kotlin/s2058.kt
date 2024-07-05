class Solution2058 {
    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        var head = head
        var first = Int.MAX_VALUE
        var last = 0
        var prev = head!!.`val`
        var minD = Int.MAX_VALUE
        var i = 0
        while (head?.next != null) {
            if (maxOf(prev, head.next!!.`val`) < head.`val` || minOf(prev, head.next!!.`val`) > head.`val`) {
                if (last != 0) minD = minOf(minD, i - last)
                first = minOf(first, i)
                last = i
            }
            prev = head.`val`
            head = head.next
            i++
        }
        return if (minD == Int.MAX_VALUE) intArrayOf(-1,-1) else intArrayOf(minD, last - first)
    }

}