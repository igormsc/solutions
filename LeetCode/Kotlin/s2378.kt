class Solution2378 {
    fun maxScore(edges: Array<IntArray>): Long {
        val n = edges.size
        val g = Array(n){ mutableListOf<IntArray>() }
        for (i in 1..<n)
            g[edges[i][0]].add(intArrayOf(i, edges[i][1]))

        fun dfs(i: Int): LongArray {
            var (a, b, c) = longArrayOf(0,0,0)
            for (nxt in g[i]) {
                val (j,w) = nxt
                val s = dfs(j)
                a += s[1]
                b += s[1]
                c = maxOf(c, s[0] - s[1] + w)
            }
            b += c
            return longArrayOf(a, b)
        }

        return dfs(0)[1]
    }

}