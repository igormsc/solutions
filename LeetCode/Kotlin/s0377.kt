class Solution377 {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target+1).also {it[0]=1}
        (1..dp.lastIndex).forEach { i ->
            nums.forEach { n -> if (i-n >= 0) dp[i] +=dp[i-n] } }
        return dp[target]
    }
}
