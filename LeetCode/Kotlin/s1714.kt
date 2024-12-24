import kotlin.math.sqrt

class Solution1714 {
    fun solve(nums: IntArray, queries: Array<IntArray>): IntArray {
        val n = nums.size
        val m = sqrt(n.toDouble()).toInt()
        val mod = 1_000_000_007
        val suf = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m)
            for (j in n - 1 downTo 0)
                suf[i][j] = (suf[i][minOf(n, j + i)] + nums[j]) % mod

        val k = queries.size
        val res = IntArray(k)
        for (i in 0..<k) {
            val (x,y) = queries[i]
            if (y <= m) res[i] = suf[y][x]
            else {
                var s = 0
                var j = x
                while (j < n) {
                    s = (s + nums[j]) % mod
                    j += y
                }
                res[i] = s
            }
        }
        return res
    }

}