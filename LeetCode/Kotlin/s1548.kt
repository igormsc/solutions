class Solution1548 {
    fun mostSimilar(n: Int, roads: Array<IntArray>, names: Array<String>, targetPath: Array<String>): List<Int> {
        val g = Array(n) { mutableListOf<Int>() }
        roads.forEach { r ->
            val (u, v) = r
            g[u].add(v)
            g[v].add(u)
        }
        val m = targetPath.size
        val f = Array(m) { IntArray(n) {Int.MAX_VALUE/2} }
        val pre = Array(m) { IntArray(n) {-1} }
        for (j in 0..<n)
            f[0][j] = if (targetPath[0] == names[j]) 0 else 1

        for (i in 1..<m)
            for (j in 0..<n)
                for (k in g[j]) {
                    val t = f[i - 1][k] + (if (targetPath[i] == names[j]) 0 else 1)
                    if (t < f[i][j]) {
                        f[i][j] = t
                        pre[i][j] = k
                    }
                }

        var mi = Int.MAX_VALUE/2
        var k = 0
        for (j in 0..<n)
            if (f[m - 1][j] < mi) {
                mi = f[m - 1][j]
                k = j
            }
        val res = mutableListOf<Int>()
        (m - 1 downTo 0).forEach {
            res.add(k)
            k = pre[it][k]
        }
        res.reverse()
        return res
    }

}