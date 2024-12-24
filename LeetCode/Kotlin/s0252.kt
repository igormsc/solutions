class Solution252 {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        intervals.sortBy { it[0] }
        return !(1..intervals.lastIndex).any { intervals[it-1][1] > intervals[it][0] }
    }

}
