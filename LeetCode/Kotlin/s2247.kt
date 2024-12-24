class Solution2247 {
    fun maximumCost(n: Int, highways: Array<IntArray>, k: Int): Int {
        if (k >= n) return -1
        val g = Array(n) { mutableListOf<IntArray>() }
        for (h in highways) {
            val (u, v, cost) = h
            g[u].add(intArrayOf(v, cost))
            g[v].add(intArrayOf(u, cost))
        }
        val f = Array(1 shl n) { IntArray(n) { Int.MIN_VALUE / 2 } }
        (0..<n).forEach { f[1 shl it][it] = 0 }
        var res = -1
        for (i in 0..<(1 shl n))
            for (j in 0..<n) {
                if ((i shr j and 1) == 1) {
                    for (e in g[j]) {
                        val (h, cost) = e
                        if ((i shr h and 1) == 1) f[i][j] = maxOf(f[i][j], f[i xor (1 shl j)][h] + cost)
                    }
                }
                if (Integer.bitCount(i) == k + 1) res = maxOf(res, f[i][j])
            }
        return res
    }

}