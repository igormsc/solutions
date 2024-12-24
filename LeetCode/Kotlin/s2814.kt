class Solution2814 {
    fun minimumSeconds(land: List<List<String>>): Int {
        val (m,n) = land.size to land[0].size
        var vis = Array(m) { BooleanArray(n) }
        val g = Array(m) { IntArray(n) }
        val q = mutableListOf<IntArray>()
        var (si, sj) = 0 to 0
        for (i in 0..<m) {
            g[i].fill( Int.MAX_VALUE/2)
            for (j in 0..<n) {
                val c = land[i][j]
                if ("*" == c) q.add(intArrayOf(i, j))
                else if ("S" == c) {
                    si = i
                    sj = j
                }
            }
        }
        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        run {
            var t = 0
            while (q.isNotEmpty()) {
                for (k in q.size downTo 1) {
                    val (i,j) = q.removeFirst()
                    g[i][j] = t
                    for (d in 0..3) {
                        val x = i + dirs[d]
                        val y = j + dirs[d + 1]
                        if (x in 0..<m && y in 0..<n && !vis[x][y]) {
                            val empty = "." == land[x][y]
                            val start = "S" == land[x][y]
                            if (empty || start) {
                                vis[x][y] = true
                                q.add(intArrayOf(x, y))
                            }
                        }
                    }
                }
                t++
            }
        }
        q.add(intArrayOf(si, sj))
        vis = Array(m) { BooleanArray(n) }
        vis[si][sj] = true
        var t = 0
        while (q.isNotEmpty()) {
            for (k in q.size downTo 1) {
                val (i,j) = q.removeFirst()
                if ("D" == land[i][j]) return t
                for (d in 0..3) {
                    val (x,y) = i + dirs[d] to j + dirs[d + 1]
                    if (x in 0..<m && y in 0..<n && !vis[x][y] && g[x][y] > t + 1) {
                        val empty = "." == land[x][y]
                        val dest = "D" == land[x][y]
                        if (empty || dest) {
                            vis[x][y] = true
                            q.add(intArrayOf(x, y))
                        }
                    }
                }
            }
            t++
        }
        return -1
    }

}