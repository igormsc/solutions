import kotlin.math.max

class Solution474 {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val dp = Array(m+1) { IntArray(n+1) }
        strs.forEach { s ->
            var (z, o) = 0 to 0
            s.forEach { if (it == '0') z++ else o++ }
            (m downTo z).forEach { i ->
                (n downTo o).forEach { j -> dp[i][j] = maxOf(dp[i][j], dp[i - z][j - o] + 1) }
            }
        }
        return dp[m][n]
    }
}