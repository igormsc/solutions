class Solution2872 {
    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        var res = 0
        val cnt = IntArray(n)
        val g = Array(n) { mutableListOf<Int>() }
        edges.forEach { (u, v) -> g[u].add(v); g[v].add(u) }
        val q = (0..<n).fold(mutableListOf<Int>()) { r, i -> cnt[i] = g[i].size .also { if (it<2) r.add(i) }; r }
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            cnt[u]--
            if (values[u] % k == 0) res++
            for (v in g[u])
                if (cnt[v] != 0) {
                    values[v] += values[u] % k
                    if (--cnt[v] == 1) q.add(v)
                }
        }
        return res
    }
}
