class Solution2174 {
    fun removeOnes(grid: Array<IntArray>): Int {
        val (m, n) = grid.size to grid[0].size
        var f = 0
        for (i in 0..<m)
            for (j in 0..<n)
                if (grid[i][j] == 1) f = f or (1 shl (i * n + j))

        val q = mutableListOf(f)
        val vis = mutableSetOf(f)
        var res = 0
        while (q.isNotEmpty()) {
            for (k in q.size downTo 1) {
                f = q.removeFirst()
                if (f == 0) return res
                for (i in 0..<m)
                    for (j in 0..<n) {
                        if (grid[i][j] == 0) continue
                        var g = f
                        for (r in 0..<m) g = g and (1 shl (r * n + j)).inv()
                        for (c in 0..<n) g = g and (1 shl (i * n + c)).inv()
                        if (!vis.contains(g)) {
                            vis.add(g)
                            q.add(g)
                        }
                    }
            }
            res++
        }
        return -1
    }

}