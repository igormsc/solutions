class Solution2257 {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        val dirs = intArrayOf(0,1,0,-1,0)
        var res = m*n - walls.size
        val g = Array(m) { IntArray(n) }
        walls.forEach { g[it[0]][it[1]] = 15 }
        guards.forEach { gd ->
            (0..3).forEach { d ->
                var (i, j) = gd
                while (i in 0..<m && j in 0..<n && (g[i][j].and(1.shl(d))== 0) ) {
                    if (g[i][j] == 0) res--
                    g[i][j] += 1.shl(d)
                    i += dirs[d]
                    j += dirs[d+1]
                }
            }
        }
        return res
    }
}
