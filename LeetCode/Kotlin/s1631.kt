import java.util.*
import kotlin.math.absoluteValue

class Solution1631 {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val (m, n) = heights.size to heights[0].size
        val dist = Array(m) { IntArray(n) {Int.MAX_VALUE/2} }.also{it[0][0]=0}
        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        val pq = PriorityQueue { a: IntArray, b: IntArray -> a[0] - b[0] }
        pq.offer(intArrayOf(0, 0, 0))
        while (!pq.isEmpty()) {
            val (t, i, j) = pq.poll()
            for (k in 0..3) {
                val (x, y) = i + dirs[k] to j + dirs[k + 1]
                if (x in 0..<m && y in 0..<n) {
                    val d = maxOf(t, (heights[x][y] - heights[i][j]).absoluteValue)
                    if (d < dist[x][y]) {
                        dist[x][y] = d
                        pq.offer(intArrayOf(d, x, y))
                    }
                }
            }
        }
        return dist[m - 1][n - 1]
    }
}
