class Solution3351 {

    fun sumOfGoodSubsequences(nums: IntArray): Int {
        val MOD = 1_000_000_007L
        val (cnt, sum) = LongArray(100_010) to LongArray(100_010)
        return nums.fold(0L) { r, n ->
            cnt[n + 1] = (cnt[n] + cnt[n + 1] + cnt[n + 2] + 1) % MOD
            val cur = sum[n] + sum[n + 2] + n.toLong() * (cnt[n] + cnt[n + 2] + 1)
            sum[n + 1] = (sum[n + 1] + cur) % MOD
            (r + cur) % MOD
        }.toInt()
    }

}