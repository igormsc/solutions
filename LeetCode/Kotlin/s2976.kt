class Solution2976 {
    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
        val maxI = Long.MAX_VALUE / 2
        val d = Array(255) { LongArray(255) { maxI } }
        original.indices.forEach { i ->
            val u = original[i].code
            val v = changed[i].code
            d[u][v] = if (d[u][v] == 0L) cost[i].toLong()
                      else minOf(d[u][v], cost[i].toLong())
        }
        val r = ('a'.code..'z'.code)
        r.forEach { k ->
            r.forEach { i ->
                r.forEach { j ->
                    d[i][j] = minOf(d[i][j], d[i][k] + d[k][j])
                }
            }
        }
        return source.indices.sumOf { i ->
                    if (source[i] != target[i]) {
                        val u = source[i].code
                        val v = target[i].code
                        if (d[u][v] >= maxI) return -1L
                        d[u][v]
                    } else 0L
                }
    }

}
