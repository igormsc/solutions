class Solution3323 {
    fun minConnectedGroups(intervals: Array<IntArray>, k: Int): Int {
        intervals.sortWith( compareBy<IntArray> { it[0]}.thenBy { it[1] } )
        val dp = IntArray(intervals.size)
        var (mx, j, l) = intArrayOf(0,0,intervals[0][1])
        (1..intervals.lastIndex).forEach { i ->
            dp[i] = dp[i-1] + if (l<intervals[i][0]) 1 else 0
            while (intervals[j][1] + k < intervals[i][0]) j++
            l = maxOf(l, intervals[i][1])
            mx = maxOf(mx, dp[i]-dp[j])
        }
        return dp.last() + 1 - mx
    }
}
