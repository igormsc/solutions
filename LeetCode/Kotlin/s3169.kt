class Solution3169 {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        meetings.sortWith(compareBy({ it[0] }, { it[1] }))
        var res = 0
        var cur = 1
        for (m in meetings) {
            res += maxOf(0, m[0] - cur)
            cur = maxOf(cur, m[1] + 1)
            if (cur > days) break
        }
        return maxOf(0, days-cur+1) + res
    }
}
