class Solution3376 {
    fun findMinimumTime(strength: List<Int>, K: Int): Int {
        val n = strength.size
        val dp = IntArray(1.shl(n)) {Int.MAX_VALUE}.also{it[0]=0}
        (0..<1.shl(n)).forEach { m ->
            val c = m.countOneBits()
            (0..<n).forEach{i ->
                if (m.and(1.shl(i)) == 0) {
                    val u = m.or(1.shl(i))
                    val x = K*c + 1
                    dp[u]=minOf(dp[u], (strength[i]+x-1)/x+dp[m])
                }
            }
        }
        return dp.last()
    }

}
