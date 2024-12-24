import java.util.*
import kotlin.math.absoluteValue

class Solution1584 {
        fun minCostConnectPoints(points: Array<IntArray>): Int {
            val n = points.size
            val vis = BooleanArray(n)
            var (cnt, res, i) = intArrayOf(0,0,0)

            val pq = PriorityQueue { a: IntArray, b: IntArray -> if (a[0] == b[0]) b[1] - a[1] else a[0] - b[0] }
            while (cnt < n - 1) {
                vis[i] = true
                (0..<n).forEach { if (!vis[it]) pq.add(intArrayOf((points[i][0] - points[it][0]).absoluteValue + (points[i][1] - points[it][1]).absoluteValue, it)) }
                while (vis[pq.peek()[1]]) pq.poll()
                res += pq.peek()[0]
                i = pq.poll()[1]
                cnt++
            }
            return res
        }
}
