class Solution253 {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val n = 1_000_010
        val d = IntArray(n)
        intervals.forEach { it
            d[it[0]]++
            d[it[1]]--
        }
        return (0..<n).maxOf { i ->
            if (i>0) d[i] += d[i-1]
            d[i] }
    }

}
