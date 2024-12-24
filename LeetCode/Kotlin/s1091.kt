class Solution1091 {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1) return -1
        val n = grid.size
        grid[0][0] = 1
        var res = 1
        val q = mutableListOf(intArrayOf(0, 0))
        while (q.isNotEmpty()) {
            for (k in q.size downTo 1) {
                val (i, j) = q.removeFirst()
                if (i == n - 1 && j == n - 1) return res
                for (x in i - 1..i + 1)
                    for (y in j - 1..j + 1)
                        if (x in 0..<n && y in 0..<n && grid[x][y] == 0) {
                            grid[x][y] = 1
                            q.add(intArrayOf(x, y)) } }
            res++ }
        return -1
    }

}