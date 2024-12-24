class Solution2077 {
    fun numberOfPaths(n: Int, corridors: Array<IntArray>): Int {
        val g = Array(n + 1) { mutableSetOf<Int>() }
        for ((u,v) in corridors) {
            g[u].add(v)
            g[v].add(u)
        }

        return (1..n).sumOf { c ->
            val q = g[c].toList()
            q.indices.sumOf { i -> (i + 1..q.lastIndex).count { g[q[it]].contains(q[i]) } } } / 3
    }

}