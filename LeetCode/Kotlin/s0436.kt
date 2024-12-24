class Solution436 {
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        val n = intervals.size
        val arr = intervals.map{it[0]}.withIndex().sortedBy { it.value }
        val res = IntArray(n)
        for (i in 0..<n) {
            val x = intervals[i][1]
            var (l, r) = 0 to arr.size
            while (l < r) {
                val m = (l + r) / 2
                if (arr[m].value >= x) r = m else l = m + 1
            }
            res[i] = if (l < n) arr[l].index else -1
        }
        return res
    }
}
