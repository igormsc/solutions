import java.util.*

class Solution3296 {
    fun minNumberOfSeconds(mountainHeight: Int, workerTimes: IntArray): Long {
        val pq = PriorityQueue<Triple<Long,Long,Long>> { a, b -> (if (a.first == b.first) if (a.second == b.second) a.third-b.third else a.second - b.second else a.first-b.first).toInt() }
        workerTimes.forEach { pq.add(Triple(it.toLong(),it.toLong(), 1L)) }
        repeat(mountainHeight-1) {
            val (a, b, c) = pq.poll()
            pq.add(Triple(a+b*(c+1), b, c+1))
        }
        return pq.poll().first
    }
}
