class Solution1820 {
    fun maximumInvitations(grid: Array<IntArray>): Int {
        val (m, n) = grid.size to grid[0].size
        val vis = BooleanArray(n)
        val match = IntArray(n) {-1}

        fun find(i: Int): Boolean {
            for (j in 0..<n)
                if (grid[i][j] == 1 && !vis[j]) {
                    vis[j] = true
                    if (match[j] == -1 || find(match[j])) {
                        match[j] = i
                        return true
                    }
                }
            return false
        }
        return (0..<m).count { vis.fill(false); find(it) }
    }
}
