class Solution265 {
    fun minCostII(costs: Array<IntArray>): Int {
        var f = costs[0].clone()
        for (i in 1..costs.lastIndex) {
            val g = costs[i].clone()
            costs[0].indices.forEach { j ->
                var t = Int.MAX_VALUE
                costs[0].indices.forEach { h -> if (h != j) t = minOf(t, f[h]) }
                g[j] += t
            }
            f = g
        }
        return f.min()
    }

}