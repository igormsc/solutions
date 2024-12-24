class Solution2204 {
    fun distanceToCycle(n: Int, edges: Array<IntArray>): IntArray {
        val g = Array(n) { mutableSetOf<Int>() }
        for (e in edges) {
            val (u, v) = e
            g[u].add(v)
            g[v].add(u)
        }
        val q = mutableListOf<Int>()
        val res = IntArray(n)
        val cnt = IntArray(n)

        for (i in 0..<n) {
            cnt[i] = g[i].size
            if (cnt[i] == 1) q.add(i)
        }

        while (q.isNotEmpty()) {
            val i = q.removeFirst()
            res[i] = Int.MAX_VALUE
            g[i].forEach { j ->
                if (cnt[j] > 1 && --cnt[j] == 1) q.add(j)
            }
        }

        for (i in 0..<n)
            if (cnt[i] > 1) q.add(i)
        while (q.isNotEmpty()) {
            val i = q.removeFirst()
            g[i].forEach { j ->
                if (res[j] > res[i] + 1) {
                    res[j] = res[i] + 1
                    q.add(j)
                }
            }
        }
        return res
    }
}
