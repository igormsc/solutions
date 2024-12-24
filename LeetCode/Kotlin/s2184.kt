import java.util.*

class Solution2184 {
    fun buildWall(height: Int, width: Int, bricks: IntArray): Int {
        val MOD = 1_000_000_007
        val res = mutableListOf<List<Int>>()
        val t =  mutableListOf<Int>()

        fun dfs(v: Int) {
            if (v == width) res.add(ArrayList(t))
            if (v < width) bricks.forEach { t.add(it); dfs(v + it); t.removeLast() }
        }
        dfs(0)

        val n = res.size
        val g = Array(n){ mutableListOf<Int>() }
        for (i in 0..<n) {
            if (chk(res[i], res[i])) g[i].add(i)
            for (j in i + 1..<n)
                if (chk(res[i], res[j])) {
                    g[i].add(j)
                    g[j].add(i)
                }
        }
        val dp = Array(height) { IntArray(n) }
        dp[0].indices.forEach {  dp[0][it] = 1 }
        for (i in 1..<height)
            for (j in 0..<n)
                for (k in g[j])
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD

        return (0..<n).fold(0) { r, i -> (r + dp[height - 1][i]) % MOD }
    }

    private fun chk(a: List<Int>, b: List<Int>): Boolean {
        var (s1, s2) = a[0] to b[0]
        var (i, j) = 1 to 1
        while (i < a.size && j < b.size) {
            if (s1 == s2) return false
            if (s1 < s2) s1 += a[i++]
            else s2 += b[j++]
        }
        return true
    }

}
