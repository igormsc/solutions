class Solution1751 {
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        val n = events.size
        events.sortBy { it[1] }
        val idx = IntArray(n)
        (0..<n).forEach { i ->
            idx[i] = -1
            var (l, r) = 0 to i-1
            while (l <= r) {
                val m = l + (r - l) / 2
                if (events[m][1] < events[i][0]) l = m+1.also{idx[i] = m} else r = m-1
            }
        }
        var prev = IntArray(n)
        (1..k).forEach { q ->
            val cur = IntArray(n)
            (0..<n).forEach { i ->
                cur[i] = events[i][2]
                val x = idx[i]
                if (x != -1) cur[i] = maxOf(cur[i], prev[x] + events[i][2])
                if (i > 0) cur[i] = maxOf(cur[i-1], cur[i])
            }
            prev = cur
        }
        return prev[n-1]
    }
}
