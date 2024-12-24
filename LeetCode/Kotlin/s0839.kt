class Solution839 {
    fun numSimilarGroups(strs: Array<String>): Int {
        val n = strs.size
        val uf = UnionFind(n)
        var res = n
        for (i in strs.indices)
            for (j in 0..<i)
                if (strs[i].indices.count { strs[i][it] != strs[j][it] } <= 2 && uf.union(i, j)) res--
        return res
    }

    internal class UnionFind(n: Int) {
        private val p = IntArray(n) {it}
        private val size = IntArray(n) {1}

        fun find(x: Int): Int = if (p[x] != x) find(p[x]).also{p[x]=it} else p[x]

        fun union(a: Int, b: Int): Boolean {
            val (pa, pb) = find(a) to find(b)
            if (pa == pb) return false
            if (size[pa] > size[pb]) p[pb] = pa.also{ size[pa] += size[pb] } else p[pa] = pb.also{ size[pb] += size[pa] }
            return true
        }
    }

}
