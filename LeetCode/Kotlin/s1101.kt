class Solution1101 {
    fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
        var n = n
        logs.sortBy { it[0] }
        val uf = UnionFind(n)
        for (log in logs) {
            val (t,x,y) = log
            if (uf.union(x, y) && --n == 1) return t
        }
        return -1
    }

    internal class UnionFind(n: Int) {
        private val p = IntArray(n) {it}
        private val size = IntArray(n) {1}

        private fun find(x: Int): Int {
            if (p[x] != x) p[x] = find(p[x])
            return p[x]
        }

        fun union(a: Int, b: Int): Boolean {
            val (pa, pb) = find(a) to find(b)
            if (pa == pb) return false
            if (size[pa] > size[pb]) {
                p[pb] = pa
                size[pa] += size[pb]
            } else {
                p[pa] = pb
                size[pb] += size[pa]
            }
            return true
        }
    }

}