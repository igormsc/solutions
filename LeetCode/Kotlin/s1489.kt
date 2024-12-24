class Solution1489 {
    fun findCriticalAndPseudoCriticalEdges(n: Int, edges: Array<IntArray>): List<List<Int>> {
        (edges.indices).forEach { i -> edges[i] = edges[i].copyOf(4).also { it[3] = i } }
        edges.sortBy { it[2] }
        var v = 0
        var uf = UnionFind(n)
        for ((f, t, w) in edges)
            if (uf.union(f, t)) v += w
        val res = Array(2) { mutableListOf<Int>() }
        for ((f, t, w, i) in edges) {
            uf = UnionFind(n)
            var k = 0
            for ((x, y, z, j) in edges)
                if (j != i && uf.union(x, y)) k += z
            if (uf.n > 1 || (uf.n == 1 && k > v)) res[0].add(i)
            else {
                uf = UnionFind(n)
                uf.union(f, t)
                k = w
                for ((x, y, z, j) in edges)
                    if (j != i && uf.union(x, y)) k += z
                if (k == v) res[1].add(i)
            }
        }
        return res.toList()
    }

    internal class UnionFind(n: Int) {
        private val p = IntArray(n)
        var n = n

        init {
            (0..<n).forEach { p[it] = it }
        }

        fun union(a: Int, b: Int): Boolean {
            if (find(a) == find(b)) return false
            p[find(a)] = find(b)
            n--
            return true
        }

        fun find(x: Int): Int {
            if (p[x] != x) p[x] = find(p[x])
            return p[x]
        }
    }

}
