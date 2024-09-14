import java.util.*
import kotlin.math.absoluteValue

class Solution3275 {
    fun resultsArray(queries: Array<IntArray>, k: Int): IntArray {
        val pq = PriorityQueue(Collections.reverseOrder<Int>())
        val res = IntArray(queries.size)
        queries.indices.forEach { i ->
            pq.add(queries[i][0].absoluteValue+queries[i][1].absoluteValue)
            if (pq.size > k) pq.poll()
            res[i] = if (pq.size==k) pq.peek() else -1
        }
        return res
    }
}
