class Solution490 {
    fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
        val (m, n) = maze.size to maze[0].size
        val vis = Array(m) { BooleanArray(n) }.also { it[start[0]][start[1]] = true}
        val q = mutableListOf(start)
        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        while (q.isNotEmpty()) {
            val (i,j) = q.removeFirst()
            for (k in 0..3) {
                var (x, y) = i to j
                val (a, b) = dirs[k] to dirs[k + 1]
                while (x + a in 0..<m && y + b in 0..<n && maze[x + a][y + b] == 0) {
                    x += a
                    y += b
                }
                if (x == destination[0] && y == destination[1]) return true
                if (!vis[x][y]) {
                    vis[x][y] = true
                    q.add(intArrayOf(x, y))
                }
            }
        }
        return false
    }

}