
import java.util.*

class Solution3367 {
    fun maximizeSumOfWeights(edges: Array<IntArray>, k: Int): Long {
        val m = HashMap<Int, MutableList<IntArray>>()
        for (edge in edges) {
            m.computeIfAbsent(edge[0]) { mutableListOf() }.add(intArrayOf(edge[1], edge[2]))
            m.computeIfAbsent(edge[1]) { mutableListOf() }.add(intArrayOf(edge[0], edge[2]))
        }

        fun maximizeSumOfWeights(v: Int, from: Int, k: Int): LongArray {
            var sum = 0L
            val queue = PriorityQueue<Long>()
            for (i in m[v]!!) {
                if (i[0] != from) {
                    val next = maximizeSumOfWeights(i[0], v, k)
                    sum += maxOf(next[0], i[1].toLong().let { next[1] += it; next[1] })
                    if (next[0] < next[1]) {
                        queue.offer(next[1] - next[0])
                        sum -= if (queue.size > k) queue.poll() else 0
                    }
                }
            }
            return longArrayOf(sum, sum - (if (queue.size < k) 0 else queue.peek()))
        }

        return maximizeSumOfWeights(0, -1, k).first()
    }
}