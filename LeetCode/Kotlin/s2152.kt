class Solution2152 {
    fun minimumLines(points: Array<IntArray>): Int {
        val n = points.size
        val f = IntArray(1 shl n)

        fun chk(i: Int, j: Int, k: Int): Boolean {
            val (x1,y1) = points[i]
            val (x2,y2) = points[j]
            val (x3,y3) = points[k]
            return (x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1)
        }

        fun dfs(u: Int): Int {
            if (u == (1 shl n) - 1) return 0
            if (f[u] != 0) return f[u]
            var res = Int.MAX_VALUE/2
            for (i in 0..<n)
                if (((u shr i) and 1) == 0) {
                    for (j in i + 1..<n) {
                        var nxt = u or (1 shl i) or (1 shl j)
                        for (k in j + 1..<n)
                            if (((u shr k) and 1) == 0 && chk(i, j, k)) nxt = nxt or (1 shl k)
                        res = minOf(res, dfs(nxt) + 1)
                    }
                    if (i == n - 1) res = minOf(res, dfs(u or (1 shl i)) + 1)
                }
            return res.also { f[u] = it }
        }

        return dfs(0)
    }

}