class Solution2501 {
    fun longestSquareStreak(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        val dp = IntArray(n).also{it[n-1]=1}
        var mx = 1
        (n-2 downTo 0).forEach{ i ->
            val t = nums[i] * nums[i]
            var (l, h) = i+1 to n-1
            var pos = -1
            while (l<=h) {
                val m = l + (h-l)/2
                if (nums[m] == t) {
                    pos = m
                    break
                } else
                    if (nums[m] < t) l = m+1
                    else if (nums[m] > t) h = m-1
            }
            dp[i] = if (pos == -1) 1 else dp[pos] + 1
            mx = maxOf(dp[i], mx)
        }
        return if (mx == 1) -1 else mx
    }
}
