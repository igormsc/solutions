class Solution3299 {
    fun getSum(nums: IntArray): Int {
        val MOD = 1_000_000_007L
        var res = 0L
        val d = Array(nums.max() + 2) { LongArray(4) }
        for (n in nums) {
            res += n.toLong()
            d[n][0] += d[n - 1][0] + 1
            d[n][1] += d[n - 1][1] + n * (d[n - 1][0] + 1)
            res += d[n - 1][1] + n * d[n - 1][0]
            d[n][2] += d[n + 1][2] + 1
            d[n][3] += d[n + 1][3] + n * (d[n + 1][2] + 1)
            res += d[n + 1][3] + n * d[n + 1][2]
            d[n].indices.forEach { d[n][it] %= MOD }
            res %= MOD
        }
        return res.toInt()
    }

}