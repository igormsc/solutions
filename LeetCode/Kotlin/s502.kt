import java.util.*

class Solution502 {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int  {
        val projects = profits.mapIndexed { i, p -> p to capital[i] }.sortedBy { it.second }
        val pq = PriorityQueue<Int>(profits.size, compareBy { -it })
        var i = 0
        var res = w
        repeat(k) {
            while (i<profits.size && projects[i].second <= res ) pq.add(projects[i++].first)
            if (pq.isNotEmpty()) res += pq.poll()
        }
        return res
    }
}