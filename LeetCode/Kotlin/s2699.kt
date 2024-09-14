class Solution2699 {
    fun modifiedGraphEdges(n: Int, edges: Array<IntArray>, source: Int, destination: Int, target: Int): Array<IntArray> {
        val d = IntArray(105) { Int.MAX_VALUE }.also { it[source] = 0 }
        val g = edges.fold(Array(105) { mutableListOf<Pair<Int, Int>>() }) { r, e ->
            if (e[2] != -1) {
                r[e[0]].add(e[1] to e[2])
                r[e[1]].add(e[0] to e[2])
            }
            r }
        val q = mutableListOf(source)

        fun fq() {
            while (q.isNotEmpty()) {
                val u = q.removeFirst()
                g[u].forEach { (nxt, w) ->
                    if (d[nxt] > d[u] + w) {
                        d[nxt] = d[u] + w
                        q.add(nxt)
                    }
                }
            }
        }
        fq()

        if (d[destination] < target) return arrayOf()
        if (d[destination] == target) {
            edges.indices.forEach { if (edges[it][2] == -1) edges[it][2] = 1_000_000_000 }
            return edges
        }

        edges.forEachIndexed { i, (u, v, w) ->
            if (w == -1) {
                edges[i][2] = 1
                g[u].add(v to 1)
                g[v].add(u to 1)
                q.clear()
                q.add(source)
                (0..<n).forEach { d[it] = Int.MAX_VALUE/2 }
                d[source] = 0
                fq()
                if (d[destination] <= target) {
                    edges[i][2] += target - d[destination]
                    (i + 1..edges.lastIndex).forEach { if (edges[it][2] == -1) edges[it][2] = 1_000_000_000 }
                    return edges
                }
            }
        }
        return arrayOf()
    }
}