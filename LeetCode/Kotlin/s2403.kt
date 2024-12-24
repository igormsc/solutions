class Solution2403 {
    fun minimumTime(power: IntArray): Long {
        val n = power.size
        val dp = LongArray(1 shl n) {Long.MAX_VALUE}.also { it[0] = 0L }
        for (mask in 1..<(1 shl n)) {
            val cnt = mask.countOneBits()
            for (i in 0..<n)
                if (((mask shr i) and 1) == 1)
                    dp[mask] = minOf(dp[mask], dp[mask xor (1 shl i)] + (power[i] + cnt - 1) / cnt)
        }
        return dp[(1 shl n) - 1]
    }

}