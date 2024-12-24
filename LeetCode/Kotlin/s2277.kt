class Solution2277 {
    fun closestNode(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
        val res = mutableListOf<Int>()
        val g = Array(n) { mutableListOf<Int>() }
        val mt = Array(n) { IntArray(n) {-1} }

        edges.forEach { e ->
            val (u,v) = e
            g[u].add(v)
            g[v].add(u)
        }

        fun dfs(i: Int, start: Int, dist: Int) {
            mt[start][i] = dist
            g[i].forEach { j -> if (mt[start][j] == -1) dfs(j,start,dist+1)
            }
        }
        (0..<n).forEach { i -> dfs(i,i,0)}

        fun dfs1(i: Int, end: Int, nd: Int, res: Int): Int {
            g[i].forEach { j -> if (mt[i][end] > mt[j][end]) return dfs1(j, end,nd, if (mt[res][nd]<mt[j][nd]) res else j ) }
            return res
        }

        query.forEach { q -> res.add(dfs1(q[0],q[1],q[2],q[0])) }
        return res.toIntArray()
    }
}
