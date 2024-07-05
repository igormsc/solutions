class Solution57 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val n = intervals.size
        var i = 0
        val res = mutableListOf<IntArray>()
        while (i < n && intervals[i][1] < newInterval[0]) res.add(intervals[i++])
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = minOf(newInterval[0], intervals[i][0])
            newInterval[1] = maxOf(newInterval[1], intervals[i][1])
            i++
        }
        res.add(newInterval)
        while (i < n) res.add(intervals[i++])
        return res.toTypedArray()
    }
}
