import kotlin.math.max

class Solution1615 {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val g = Array(n) { IntArray(n) }
        val cnt = IntArray(n)
        for ((u, v) in roads) {
            g[u][v] = 1
            g[v][u] = 1
            cnt[u]++
            cnt[v]++
        }
        var res = 0
        for (u in 0..<n)
            for (v in u + 1..<n)
                res = maxOf(res, cnt[u] + cnt[v] - g[u][v])
        return res
    }
}
