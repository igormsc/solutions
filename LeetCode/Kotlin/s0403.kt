class Solution403 {
    fun canCross(stones: IntArray): Boolean {
        val n = stones.size
        val dp = Array(n) { BooleanArray(n+1)}.also{it[0][1]=true}
        (1..<n).forEach {i ->
            (0..<i).forEach {j->
                val diff = stones[i] - stones[j]
                if (diff in 1..<n && dp[j][diff]) {
                    dp[i][diff] = true
                    dp[i][diff - 1] = true
                    if (diff + 1 <= n) dp[i][diff + 1] = true
                    if (i == n - 1) return true
                }
            }
        }
        return false
    }
}
