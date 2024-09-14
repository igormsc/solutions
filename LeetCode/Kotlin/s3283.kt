class Solution3283 {
    fun maxMoves(kx: Int, ky: Int, positions: Array<IntArray>): Int {
        val pos = positions.toMutableList()
        pos.add(intArrayOf(kx,ky))

        val mvs = Array(17) {IntArray(17)}
        val dp = Array(17) {IntArray(1 shl 16)}
        val dirs = intArrayOf(1, 2, 1, -2, -1, 2, -1, -2, 1)

        fun bfs(i:Int) {
            val b = Array(50) {IntArray(50) }
            val (sx, sy) = pos[i]
            var q = mutableListOf(intArrayOf(sx,sy))
            while (q.isNotEmpty()) {
                val q1 = mutableListOf<IntArray>()
                q.forEach { (x,y) ->
                    (0..7).forEach { d ->
                        val (dx,dy) = x+dirs[d] to y+dirs[d+1]
                        if (dx >=0 && dy >= 0 && dx < 50 && dy <50 && (dx != sx || dy != sy) && b[dx][dy] == 0)
                            b[dx][dy] = b[x][y] + 1.also{ q1.add(intArrayOf(dx, dy)) }
                    }
                }
                q = q1
            }
            (i+1..pos.lastIndex).forEach { j -> b[pos[j][0]][pos[j][1]].also{mvs[i][j] = it; mvs[j][i] = it}   }
        }
        pos.indices.forEach { bfs(it)  }
        pos.removeLast()

        fun dfs(i: Int, mask: Int, turns: Int): Int {
            if (turns == pos.size) return 0
            if (dp[i][mask] == 0) {
                dp[i][mask] = if (turns%2 != 0) Int.MAX_VALUE else 0
                pos.indices.forEach { j ->
                    if ((1.shl(j)).and(mask) == 0) {
                        val z = mvs[i][j] + dfs(j, mask + (1.shl(j)), turns + 1)
                        dp[i][mask] = if (turns%2!=0) minOf(dp[i][mask], z) else maxOf(dp[i][mask], z)
                    }
                }
            }
            return dp[i][mask]
        }
        return dfs(pos.size, 0,0)
    }
}