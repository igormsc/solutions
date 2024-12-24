import java.util.*

class Solution1167 {
    fun connectSticks(sticks: IntArray): Int {
        val pq = PriorityQueue<Int>()
        sticks.forEach{ pq.offer(it) }

        var res = 0
        while (pq.size > 1) {
            val z = pq.poll() + pq.poll()
            res += z
            pq.offer(z)
        }
        return res
    }

}