class Solution2054 {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        events.sortBy { it[0] }
        val n = events.size
        val dp = IntArray(n + 1)
        (events.lastIndex downTo 0).forEach { dp[it] = maxOf(dp[it + 1], events[it][2]) }
        var res = 0
        for (e in events) {
            var x = e[2]
            var (l, r) = 0 to n
            while (l < r) {
                val m = (l + r) / 2
                if (events[m][0] > e[1]) r = m else l = m + 1
            }
            if (l < n) x += dp[l]
            res = maxOf(res,x)
        }
        return res
    }
}
