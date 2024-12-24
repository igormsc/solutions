class Solution3311 {
    fun constructGridLayout(n: Int, edges: Array<IntArray>): Array<IntArray> {
        val g = Array(n) { mutableSetOf<Int>() }
        edges.forEach { (u,v) ->
            g[u].add(v)
            g[v].add(u)
        }
        val deg = g.map{it.size}
        val md = deg.min()
        val corners = (0..<n).filter{deg[it]==md}

        fun dis(i: Int): IntArray {
            val d = IntArray(n){Int.MAX_VALUE}.also{it[i]=1}
            val bfs = mutableListOf(i)
            while (bfs.isNotEmpty()) {
                val i = bfs.removeFirst()
                for (j in g[i])
                    if (d[j] == Int.MAX_VALUE) {
                        d[j] = d[i] + 1
                        bfs.add(j)
                    }
            }
            return d
        }

        val d = dis(corners[0])
        val c = corners.map{d[it]}.sorted()[1]
        val d2 = dis(corners.filter{d[it]==c}[0])
        val res = (0..<n).sortedWith ( compareBy<Int>{ d[it] + d2[it] }.thenBy{d[it]} )
        return (0..<n step c).map{res.slice(it..<it+c).toIntArray()}.toTypedArray()
    }
}