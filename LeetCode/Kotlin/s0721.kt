class Solution721 {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val n = accounts.size
        val uf = UnionFind(n)
        val d = mutableMapOf<String, Int>()
        for (i in accounts.indices)
            for (j in 1..accounts[i].lastIndex) {
                val email = accounts[i][j]
                if (d.containsKey(email)) uf.union(i, d[email]!!) else d[email] = i
            }
        val g = mutableMapOf<Int, MutableSet<String>>()
        for (i in accounts.indices) {
            val root = uf.find(i)
            g.computeIfAbsent( root) { HashSet() }.addAll(accounts[i].subList(1, accounts[i].size)) }
        val res = mutableListOf<MutableList<String>>()
        for ((key, value) in g) {
            res.add(mutableListOf(accounts[key][0]))
            res.last().addAll(value.toMutableList().sorted())
        }
        return res
    }

    internal class UnionFind(n: Int) {
        private val p = IntArray(n) {it}
        private val size = IntArray(n) {1}

        fun find(x: Int): Int = if (p[x] != x) find(p[x]).also{p[x]=it} else p[x]

        fun union(a: Int, b: Int): Boolean {
            val (pa, pb) = find(a) to find(b)
            if (pa == pb) return false
            if (size[pa] > size[pb]) p[pb] = pa.also{size[pa] += size[pb]}
            else p[pa] = pb.also{size[pb] += size[pa]}
            return true
        }
    }

}
