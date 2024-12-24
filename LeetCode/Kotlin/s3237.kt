class Solution3237 {
    fun simulationResult(windows: IntArray, queries: IntArray): IntArray {
        val n = windows.size
        val s = BooleanArray(n + 1)
        val res = IntArray(n)
        var k = 0
        for (i in queries.indices.reversed()) {
            val q = queries[i]
            if (!s[q]) res[k++] = q.also { s[q] = true }
        }
        for (w in windows)
            if (!s[w]) res[k++] = w
        return res
    }

}