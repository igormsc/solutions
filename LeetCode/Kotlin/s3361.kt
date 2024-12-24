import java.util.*

class Solution3362 {
    fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
        val (n, nq) = nums.size to queries.size
        queries.sortBy { it[0] }
        val pq = PriorityQueue<Int>()
        val arr = IntArray(n + 1)
        var (cur, j) = 0 to 0
        for (i in 0..<n) {
            cur -= arr[i]
            while (j < nq && queries[j][0] <= i)
                pq.offer(-queries[j++][1])
            while (cur < nums[i]) {
                if (pq.isEmpty() || -pq.peek() < i) return -1
                arr[-pq.poll() + 1]++
                cur++
            }
        }
        return pq.size
    }
}
