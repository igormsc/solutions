class Solution740 {
    fun deleteAndEarn(nums: IntArray): Int {
        val sm = IntArray(10_001)
        nums.forEach{ sm[it] += it }
        val dp = IntArray(10_001).also{it[0] = sm[0]; it[1]=sm[1]}
        (2..sm.lastIndex).forEach{ dp[it] = maxOf(sm[it]+dp[it-2], dp[it-1])}
        return dp.last()
    }
}
