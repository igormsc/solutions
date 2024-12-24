import java.util.*

class Solution3341 {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val (n, m) = moveTime.size to moveTime[0].size
        val dp = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        val h = PriorityQueue(Comparator.comparingInt { a: IntArray -> a[0] })
        h.offer(intArrayOf(0, 0, 0))
        moveTime[0][0] = -1

        while (h.isNotEmpty()) {
            val (t, i, j) = h.poll()
            if (t >= dp[i][j]) continue
            if (i == n - 1 && j == m - 1) return t
            dp[i][j] = t
            val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
            for (dir in dirs) {
                val (x, y) = i + dir[0] to j + dir[1]
                if (x in 0..<n && y in 0..<m && dp[x][y] == Int.MAX_VALUE) {
                    h.offer(intArrayOf((maxOf(moveTime[x][y], t) + 1), x, y))
                }
            }
        }
        return -1
    }
}