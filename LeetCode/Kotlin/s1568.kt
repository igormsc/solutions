class Solution1568 {
    fun minDays(grid: Array<IntArray>): Int {
        val r = grid.size
        val c = grid[0].size
        val vis = Array(r) { BooleanArray(c) }
        fun dfs (i: Int, j: Int)  {
                if (i in 0..grid.lastIndex && j in 0..grid[0].lastIndex && grid[i][j] != 0 && !vis[i][j]) {
                    vis[i][j] = true
                    dfs(i+1, j)
                    dfs(i-1, j)
                    dfs(i, j+1)
                    dfs(i, j-1)
                }
            }
        var cnt = 0
        var time = 1
        var cut = false
        var root = -1
        val adj = Array(r*c) { mutableListOf<Int>() }
        val dis = IntArray(r*c)
        val low = IntArray(r*c)
        var sum = 0

        fun mark(i: Int, j: Int, u: Int, v: Int) {
            if (u in 0..grid.lastIndex && v in 0..grid[0].lastIndex && grid[u][v] != 0) {
                val id1 = i * grid[0].size + j
                val id2 = u * grid[0].size + v
                adj[id1].add(id2)
                adj[id2].add(id1)
            }
        }

        fun tarjan(p: Int, r: Int) {
            if (cut) return
            val ch = adj[r]
            dis[r] = time
            low[r] = time
            time++
            var nd = 0
            for (c in ch) {
                if (c==p) continue
                if (dis[c] == 0) {
                    nd++
                    tarjan(r, c)
                    if (low[r] > low[c]) low[r] = low[c]
                    if ((r==root && nd >1) || (low[c] >= dis[r] && r != root)) { cut = true; return}
                } else if (low[r] >dis[c]) low[r] = dis[c]
            }
        }

        grid.indices.forEach { i ->
            grid[0].indices.forEach { j ->
                sum += grid[i][j]
                if (grid[i][j] != 0 && !vis[i][j]) {
                    if (root == -1) root = i*grid[0].size + j
                    cnt++
                    dfs(i,j)
                }
            }
        }

        if (cnt>1) return 0
        if (sum<=2) return sum

        grid.indices.forEach { i ->
            grid[0].indices.forEach { j ->
                if (grid[i][j] != 0) {
                    mark(i,j,i+1,j)
                    mark(i,j,i-1,j)
                    mark(i,j,i,j+1)
                    mark(i,j,i,j-1)
                }
            }
        }
        tarjan(-1, root)
        if (cut) return 1
        return 2
    }

}

