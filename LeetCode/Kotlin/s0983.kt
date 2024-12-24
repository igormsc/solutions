class Solution983 {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val m = days.toMutableSet()
        val dp = IntArray(30)
        for (d in days[0]..days.last())
            dp[d%30] = if (m.contains(d)) minOf(dp[(d-1)%30] + costs[0], dp[maxOf(0, d-7)%30] + costs[1], dp[maxOf(0, d-30)%30] + costs[2]) else dp[(d-1)%30]
        return dp[days.last()%30]
    }
}
