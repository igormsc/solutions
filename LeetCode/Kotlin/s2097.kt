class Solution2097 {
    fun validArrangement(pairs: Array<IntArray>): Array<IntArray> {
        val ind = mutableMapOf<Int,Int>()
        val out = mutableMapOf<Int,Int>()
        val gm = mutableMapOf<Int,MutableList<Int>>()
        val path = mutableListOf<Int>()
        val gs = mutableSetOf<Int>()
        for ((u,v) in pairs) {
            out[u] = (out[u]?:0) + 1
            ind[v] = (ind[v]?:0) + 1
            gm.computeIfAbsent(u) { mutableListOf() }.add(v)
            gs.add(u)
            gs.add(v)
        }

        var start = pairs[0][0]
        gs.forEach { if ((ind[it]?:0) < (out[it]?:0)) start = it }

        fun dfs(u: Int) {
            while ((out[u]?:0) != 0) {
                out[u] = out[u]!! - 1
                dfs(gm[u]!![out[u]!!])
            }
            path.add(u)
        }

        dfs(start)

        val res = mutableListOf<IntArray>()
        var from = path.removeLast()
        while (path.isNotEmpty()) {
            val to = path.removeLast()
            res.add(intArrayOf(from, to))
            from = to
        }
        return res.toTypedArray()
    }
}
