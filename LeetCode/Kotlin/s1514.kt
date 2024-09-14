class Solution1514 {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start_node: Int, end_node: Int): Double {
        val g = Array(n) { mutableListOf<Pair<Int,Double>>() }
        edges.forEachIndexed { i, e ->
            if (succProb[i] != 0.0) {
                g[e[0]].add(e[1] to succProb[i])
                g[e[1]].add(e[0] to succProb[i])
            }
        }
        val probs = DoubleArray(n).also { it[start_node] = 1.0 }
        var q = mutableListOf(start_node)
        while (q.isNotEmpty()) {
            val q1 = mutableListOf<Int>()
            q.forEach { from ->
                g[from].forEach { p ->
                    val (to, pr) = p
                    if (probs[to] < probs[from]*pr) probs[to] = probs[from]*pr .also{q1.add(to)}
                }
            }
            q = q1
        }
        return probs[end_node]
    }
}