class Solution3141 {
    fun maxHammingDistances(nums: IntArray, m: Int): IntArray {
        val sz = 1.shl(m)
        val dp = IntArray(sz) { Int.MIN_VALUE }.also { r -> nums.forEach { r[it] = 0 } }
        val res = IntArray(nums.size)
        for (b in 0..<m) {
            val prev = dp.clone()
            for (num in 0..<sz) dp[num] = maxOf(dp[num], prev[num xor (1 shl b)] + 1)
        }
        nums.indices.forEach { res[it] = dp[nums[it]] }

        return res
    }
}