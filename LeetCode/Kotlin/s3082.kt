class Solution3082 {
    fun sumOfPower(nums: IntArray, k: Int): Int =
        nums.fold(LongArray(101).also { it[0] = 1 }) { dp, n ->
            (k downTo 0).forEach { dp[it] = (2L * dp[it] + if (it >= n) dp[it - n] else 0) % 1_000_000_007L }
            dp
        }[k].toInt()
}
