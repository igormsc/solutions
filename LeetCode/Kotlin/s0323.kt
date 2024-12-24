class Solution323 {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val uf = UnionFind(n)
        return n - edges.count{ e -> uf.union(e[0], e[1]) }
    }

    internal class UnionFind(n: Int) {
        private val p = IntArray(n) { it }
        private val sz = IntArray(n) { 1 }

        private fun find(x: Int): Int {
            if (p[x] != x) p[x] = find(p[x])
            return p[x]
        }

        fun union(a: Int, b: Int): Boolean {
            val (pa, pb) = find(a) to find(b)
            if (pa == pb) return false
            if (sz[pa] > sz[pb]) {
                p[pb] = pa
                sz[pa] += sz[pb]
            } else {
                p[pa] = pb
                sz[pb] += sz[pa]
            }
            return true
        }
    }

}