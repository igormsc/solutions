class Solution317 {
    fun shortestDistance(grid: Array<IntArray>): Int {
        val (m, n) = grid.size to grid[0].size
        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        val dist = Array(m) { IntArray(n) }
        val cnt = Array(m) { IntArray(n) }
        val q = mutableListOf<IntArray>()
        var total = 0
        for (i in 0..<m)
            for (j in 0..<n)
                if (grid[i][j] == 1) {
                    total++
                    q.add(intArrayOf(i, j))
                    var d = 0
                    val vis = Array(m) { BooleanArray(n) }
                    while (q.isNotEmpty()) {
                        d++
                        for (k in q.size downTo 1) {
                            val p = q.removeFirst()
                            for (l in 0..3) {
                                val x = p[0] + dirs[l]
                                val y = p[1] + dirs[l + 1]
                                if (x in 0..<m && y in 0..<n && grid[x][y] == 0 && !vis[x][y]) {
                                    cnt[x][y]++
                                    dist[x][y] += d
                                    q.add(intArrayOf(x, y))
                                    vis[x][y] = true
                                }
                            }
                        }
                    }
                }
        var res = Int.MAX_VALUE
        for (i in 0..<m)
            for (j in 0..<n)
                if (grid[i][j] == 0 && cnt[i][j] == total) res = minOf(res, dist[i][j])
        return if (res == Int.MAX_VALUE) -1 else res
    }

}