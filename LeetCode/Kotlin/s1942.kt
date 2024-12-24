import java.util.*

class Solution1942 {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val tArrival = times[targetFriend].first()
        times.sortWith(compareBy<IntArray>{it[0]}.thenBy{it[1]} )
        val reserved = PriorityQueue<IntArray>  {a,b -> if (a[0]==b[0]) a[1]-b[1] else a[0]-b[0] }
        val avail = PriorityQueue<Int>()
        for (t in times) {
            while (reserved.isNotEmpty() && reserved.peek().first() <= t[0]) avail.add(reserved.poll()[1])
            if (t[0] == tArrival) break
            if (avail.isEmpty()) reserved.add(intArrayOf(t[1],reserved.size))
            else reserved.add(intArrayOf(t[1], avail.poll()))
        }
        return if (avail.isEmpty()) reserved.size else avail.first()
    }

}