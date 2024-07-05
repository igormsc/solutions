import java.util.PriorityQueue

class Solution3092 {
    fun mostFrequentIDs(nums: IntArray, freq: IntArray): LongArray {
        val f = mutableMapOf<Int, Long>()
        val pq = PriorityQueue<Pair<Int, Long>>(compareByDescending{it.second})
        val res = LongArray(nums.size)
        nums.forEachIndexed { i, n ->
            f[n] = (f[n] ?: 0) + freq[i]
            pq.add(n to f[n]!!)
            while ((f[pq.peek().first] ?: 0) != pq.peek().second) pq.poll()
            res[i] = pq.peek().second
        }
        return res
    }

}