class Solution3386 {
    fun buttonWithLongestTime(events: Array<IntArray>): Int {
        var (j, mx) = events[0]
        for (i in 1..events.lastIndex) {
            val d = events[i][1] - events[i - 1][1]
            when {
                d == mx -> j = minOf(events[i][0], j)
                d > mx -> {
                    j = events[i][0]
                    mx = events[i][1] - events[i - 1][1]
                }
            }
        }
        return j
    }
}