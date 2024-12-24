import java.util.*

class Solution1508 {
    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val MOD = 1_000_000_007
        val pq = PriorityQueue<Pair<Int, Int>> { a,b -> if (a.first == b.first) a.second - b.second else a.first - b.first }
        nums.indices.forEach { pq.add(Pair(nums[it], it+1)) }
        var res = 0
        (1..right).forEach {
            val p = pq.poll()
            if (it >= left) res = (res+p.first)%MOD
            if (p.second < n) pq.add(p.first + nums[p.second] to p.second + 1)
        }
        return res
    }
}
