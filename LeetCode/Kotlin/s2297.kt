class Solution2297 {
    fun minCost(nums: IntArray, costs: IntArray): Long {
        val n = nums.size
        val g = Array(n){mutableListOf<Int>()}
        val stk = mutableListOf<Int>()
        for (i in n - 1 downTo 0) {
            while (stk.isNotEmpty() && nums[stk.last()] < nums[i]) stk.removeLast()
            if (stk.isNotEmpty()) g[i].add(stk.last())
            stk.add(i)
        }
        stk.clear()
        for (i in n - 1 downTo 0) {
            while (stk.isNotEmpty() && nums[stk.last()] >= nums[i]) stk.removeLast()
            if (stk.isNotEmpty()) g[i].add(stk.last())
            stk.add(i)
        }
        val dp = LongArray(n) { Long.MAX_VALUE/2}.also { it[0]=0L }
        for (i in 0..<n)
            for (j in g[i])
                dp[j] = minOf(dp[j], dp[i] + costs[j])

        return dp.last()
    }

}