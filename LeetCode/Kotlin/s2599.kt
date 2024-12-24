import java.util.*

class Solution2599 {
    fun makePrefSumNonNegative(nums: IntArray): Int {
        val pq = PriorityQueue<Int>()
        var res = 0
        var s = 0L
        for (n in nums) {
            s += n.toLong()
            if (n < 0) pq.offer(n)
            while (s < 0) {
                s -= pq.poll().toLong()
                res++
            }
        }
        return res
    }

}