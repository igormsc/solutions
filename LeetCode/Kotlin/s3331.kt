class Solution3331 {

    fun findSubtreeSizes(parent: IntArray, s: String): IntArray {
        val n = s.length
        val bs = s.map{it.code - 97}
        val adj = (1..<n).fold(mutableMapOf<Int, MutableList<Int>>()) { r, i -> r.computeIfAbsent(parent[i]) { mutableListOf() }; r[parent[i]]!!.add(i); r}
        val res = IntArray(n) {1}
        val ancestor = IntArray(26){-1}

        fun dfs(node: Int) {
            val prev = ancestor[bs[node]]
            ancestor[bs[node]]  = node
            (adj[node]?: emptyList()).forEach { n ->
                dfs(n)
                if (ancestor[bs[n]] == -1) res[node] += res[n]
                else res[ancestor[bs[n]]] += res[n]
            }
            ancestor[bs[node]] = prev
        }

        dfs(0)
        return res

    }

}
