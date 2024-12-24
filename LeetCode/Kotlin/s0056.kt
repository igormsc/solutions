class Solution56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy { it[0] })
        var i = 0
        val n = intervals.lastIndex
        (1..n).forEach { j ->
            if (intervals[j][0] > intervals[i][1]) {i++ ;intervals[i] = intervals[j]}
            else if (intervals[i][1] < intervals[j][1]) intervals[i][1] = intervals[j][1]
        }
        return if (n>i) intervals.slice(0..intervals.lastIndex-n+i).toTypedArray() else intervals
    }
}
