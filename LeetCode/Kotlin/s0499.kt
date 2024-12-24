class Solution499 {
    fun findShortestWay(maze: Array<IntArray>, ball: IntArray, hole: IntArray): String {
        val (m, n) = maze.size to maze[0].size
        val (r,c) = ball
        val (rh, ch) = hole
        val q = mutableListOf(intArrayOf(r, c))
        val dist = Array(m) { IntArray(n)  {Int.MAX_VALUE}}
        dist[r][c] = 0
        val path = Array(m) { arrayOfNulls<String>(n) }
        path[r][c] = ""
        val dirs = arrayOf(Triple(-1, 0, "u"), Triple(1, 0, "d"), Triple(0, -1, "l"), Triple(0, 1, "r"))
        while (q.isNotEmpty()) {
            val (i,j) = q.removeFirst()
            for (dir in dirs) {
                val (a, b, d) = dir
                var (x, y) = i to j
                var step = dist[i][j]
                while (x + a in 0..<m && y + b in 0..<n && maze[x + a][y + b] == 0 && (x != rh || y != ch)) {
                    x += a
                    y += b
                    step++
                }
                if (dist[x][y] > step || (dist[x][y] == step && (path[i][j] + d) < path[x][y]!!)) {
                    dist[x][y] = step
                    path[x][y] = path[i][j] + d
                    if (x != rh || y != ch) q.add(intArrayOf(x, y))
                }
            }
        }
        return if (path[rh][ch] == null) "impossible" else path[rh][ch]!!
    }

}