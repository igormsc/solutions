class Solution1129 {
    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        val g = Array(n) { mutableListOf<IntArray>() }
        redEdges.forEach { (u, v) -> g[u].add(intArrayOf(v, 0)) }
        blueEdges.forEach { (u, v) -> g[u].add(intArrayOf(v, 1)) }
        val cost = Array(n) { intArrayOf(-1,-1) }.also{it[0] = intArrayOf(0,0) }
        val q = mutableListOf(intArrayOf(0,0), intArrayOf(0,1))
        while (q.isNotEmpty()) {
            val (u, c1) = q.removeFirst()
            g[u].forEach { (v, c2) ->
                if (cost[v][c2] == -1 && c1 != c2) {
                    cost[v][c2] = cost[u][c1] + 1
                    q.add(intArrayOf(v, c2))
                }
            }
        }
        val res = mutableListOf<Int>()
        cost.forEach { (a, b) -> res.add((if (a > b) b to a else a to b).let{ if (it.first != -1) it.first else it.second }) }
        return res.toIntArray()
    }
}
