class Solution310 {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n==0) return listOf()
        if (n==1) return listOf(0)
        val dgs = IntArray(n)
        val adj = Array(n) { mutableListOf<Int>() }
        edges.forEach { e ->
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
            dgs[e[1]]++
            dgs[e[0]]++
        }
        val q = mutableListOf<Int>()
        dgs.forEachIndexed{ i, d -> if (d==1) q.add(i) }
        var res = mutableListOf<Int>()
        while (q.isNotEmpty()) {
            res = mutableListOf()
            val last = q.lastIndex
            (0..last).forEach { i ->
                val cur = q.removeFirst()
                res.add(cur)
                adj[cur].forEach { n ->
                    dgs[n]--
                    if (dgs[n]==1) q.add(n)
                }
            }
        }
        return res
    }
}