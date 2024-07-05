import java.util.PriorityQueue

class Solution3080 {
    fun unmarkedSumArray(nums: IntArray, queries: Array<IntArray>): LongArray {
        var res = mutableListOf<Long>()
        var sum = nums.sumOf { it.toLong() }
        val pq =
            PriorityQueue<Pair<Int, Int>> { a, b -> if (a.first == b.first) a.second - b.second else a.first - b.first }
        nums.forEachIndexed { i, n -> pq.add(n to i) }
        queries.forEach { q ->
            if (pq.remove(nums[q[0]] to q[0])) sum -= nums[q[0]]
            var k = q[1]
            while (pq.isNotEmpty() && k > 0) {
                sum -= pq.poll().first
                k--
            }
            res.add(sum)
        }
        return res.toLongArray()
    }

}


