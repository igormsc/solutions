class DistanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>) {
    private val puf = PersistentUnionFind(n)

    init {
        edgeList.sortBy { it[2] }
        edgeList.forEach { e -> puf.union(e[0], e[1], e[2]) }
    }

    fun query(p: Int, q: Int, limit: Int): Boolean = puf.find(p, limit) == puf.find(q, limit)

    internal class PersistentUnionFind(n: Int) {
        private val rank = IntArray(n)
        private val parent = IntArray(n)
        private val version = IntArray(n)

        init {
            for (i in 0..<n) {
                parent[i] = i
                version[i] = Int.MAX_VALUE / 2
            }
        }

        fun find(x: Int, t: Int): Int {
            if (parent[x] == x || version[x] >= t) return x
            return find(parent[x], t)
        }

        fun union(a: Int, b: Int, t: Int): Boolean {
            val (pa, pb) = find(a, Int.MAX_VALUE / 2) to find(b, Int.MAX_VALUE / 2)
            if (pa == pb) return false
            if (rank[pa] > rank[pb]) {
                version[pb] = t
                parent[pb] = pa
            } else {
                version[pa] = t
                parent[pa] = pb
                if (rank[pa] == rank[pb]) rank[pb]++
            }
            return true
        }
    }
}

