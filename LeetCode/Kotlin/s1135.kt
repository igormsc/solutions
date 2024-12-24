class Solution1135 {
    fun minimumCost(n: Int, connections: Array<IntArray>): Int {
        var n = n
        connections.sortBy{it[2]}
        val p = IntArray(n) {it}

        fun find(x: Int): Int {
            if (p[x] != x) p[x] = find(p[x])
            return p[x]
        }

        var res = 0
        for (e in connections) {
            val x = e[0] - 1
            val y = e[1] - 1
            val cost = e[2]
            if (find(x) == find(y)) continue
            p[find(x)] = find(y)
            res += cost
            if (--n == 1) return res
        }
        return -1
    }

}