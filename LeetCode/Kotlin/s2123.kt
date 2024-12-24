class Solution2123 {
    fun minimumOperations(grid: Array<IntArray>): Int {
        val g = mutableMapOf<Int, MutableList<Int>>()
        val vis = mutableSetOf<Int>()
        val (m,n) = grid.size to grid[0].size
        for (i in 0..<m)
            for (j in 0..<n)
                if ((i + j) % 2 == 1 && grid[i][j] == 1) {
                    val x = i * n + j
                    if (i < m - 1 && grid[i + 1][j] == 1) g.computeIfAbsent(x) { mutableListOf() }.add(x + n)
                    if (i > 0 && grid[i - 1][j] == 1) g.computeIfAbsent(x){mutableListOf()}.add(x - n)
                    if (j < n - 1 && grid[i][j + 1] == 1) g.computeIfAbsent(x) { mutableListOf() }.add(x + 1)
                    if (j > 0 && grid[i][j - 1] == 1) g.computeIfAbsent(x) { mutableListOf() }.add(x - 1)

                }
        val match = IntArray(m * n) {-1}
        var res = 0

        fun find(i: Int): Int {
            for (j in g[i]!!)
                if (vis.add(j) && (match[j] == -1 || find(match[j]) == 1)) {
                    match[j] = i
                    return 1
                }
            return 0
        }

        for (i in g.keys) {
            res += find(i)
            vis.clear()
        }
        return res
    }

}