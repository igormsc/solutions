class Solution1770 {
    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        val dp = IntArray(nums.size+1)
        var res = nums.size - multipliers.size
        (multipliers.lastIndex downTo 0).forEach { i ->
            (0..nums.lastIndex-res).forEach { dp[it] = maxOf(dp[it]+multipliers[i]*nums[it+res], dp[it+1]+multipliers[i]*nums[it]) }
            res++
        }
        return dp.first()
    }
}
