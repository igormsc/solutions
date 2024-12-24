import java.util.*

class Solution2406 {
    fun minGroups(intervals: Array<IntArray>): Int {
        intervals.sortWith(compareBy{it[0]})
        val pq = PriorityQueue<Int>()
        intervals.forEach { i ->
            if (pq.isNotEmpty() && pq.peek() < i[0]) pq.poll()
            pq.add(i[1])
        }
        return pq.size
    }
}
