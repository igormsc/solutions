class Solution2392 {
    fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {

        fun khan(r: Array<IntArray>): List<Int> {
            val cnt = IntArray(k+1)
            val adj = Array(k+1){ mutableListOf<Int>() }
            r.forEach {
                cnt[it[1]]++
                adj[it[0]].add(it[1])
            }
            val q = (1..k).fold(mutableListOf<Int>()) { a, i -> if (cnt[i] == 0) a.add(i); a}
            val res = mutableListOf<Int>()
            while (q.isNotEmpty()) {
                val y = q.removeFirst()
                res.add(y)
                adj[y].forEach { x ->
                    cnt[x]--
                    if (cnt[x] == 0) q.add(x)
                }
            }
            return res
        }

        val row = khan(rowConditions).also { if (it.size!= k) return arrayOf() }
        val col = khan(colConditions).also { if (it.size!= k) return arrayOf() }
        val idx = col.foldIndexed(IntArray(k+1)) { i, a, c -> a[c] = i; a}

        return (0..<k).fold(Array(k){IntArray(k)}) { m, i ->  m[i][idx[row[i]]] = row[i]; m }
    }
}
