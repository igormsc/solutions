import java.util.*
import kotlin.collections.ArrayList

class Solution759 {
    fun employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
        val res: ArrayList<Interval> = ArrayList()
        val pq = PriorityQueue { a: IntArray, b: IntArray -> schedule[a[0]][a[1]].start - schedule[b[0]][b[1]].start }
        for (i in schedule.indices)
            pq.add(intArrayOf(i, 0))
        var prev = schedule[pq.peek()[0]][pq.peek()[1]].start
        while (pq.isNotEmpty()) {
            val index = pq.poll()
            val interval = schedule[index[0]][index[1]]
            if (interval.start > prev)
                res.add(Interval(prev, interval.start))
            prev = maxOf(prev, interval.end)
            if (schedule[index[0]].size > index[1] + 1)
                pq.add(intArrayOf(index[0], index[1] + 1))
        }
        return res
    }
}

class Interval {
    var start: Int = 0
    var end: Int = 0

    constructor(_start: Int, _end: Int) {
        start = _start
        end = _end
    }
}
