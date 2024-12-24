class Solution505 {
    fun shortestDistance(maze: Array<IntArray>, start: IntArray, destination: IntArray): Int {
        val (m, n) = maze.size to maze[0].size
        val dist = Array(m) { IntArray(n) { Int.MAX_VALUE / 2 } }
        val (si, sj) = start
        val (di, dj) = destination
        dist[si][sj] = 0
        val q = mutableListOf(intArrayOf(si, sj))
        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        while (q.isNotEmpty()) {
            val (i, j) = q.removeFirst()
            (0..3).forEach { d ->
                var (x, y) = i to j
                var k = dist[i][j]
                val a = dirs[d]
                val b = dirs[d + 1]
                while (x + a in 0..<m && y + b in 0..<n && maze[x + a][y + b] == 0) {
                    x += a
                    y += b
                    k++
                }
                if (k < dist[x][y]) {
                    dist[x][y] = k
                    q.add(intArrayOf(x, y))
                }
            }
        }
        return if (dist[di][dj] == Int.MAX_VALUE / 2) -1 else dist[di][dj]
    }

}