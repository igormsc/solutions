class Solution1444 {
    fun ways(pizza: Array<String>, k: Int): Int {
        val mod = 1_000_000_007L
        val (m, n) = pizza.size to pizza[0].length
        val sums = Array(m+1) { LongArray(n+1)}
        val dp = Array(m) { Array(n) { LongArray(k+1) {Long.MIN_VALUE} } }
        (m-1 downTo 0).forEach { i ->
            (n-1 downTo 0).forEach { j -> sums[i][j] = sums[i+1][j] + sums[i][j+1] - sums[i+1][j+1] + if (pizza[i][j] == 'A') 1 else 0 } }

        fun dfs(i: Int, j: Int, v: Int): Long =
            when {
                dp[i][j][v] != Long.MIN_VALUE -> dp[i][j][v]
                (v == k) -> (if (sums[i][j] > 0L) 1L else 0L).also {dp[i][j][v]=it}
                else -> {
                    var res = 0L
                    (i..<m-1).forEach{if (sums[i][j]-sums[it+1][j] > 0) res = (res + dfs(it+1, j, v+1))%mod}
                    (j..<n-1).forEach{if (sums[i][j]-sums[i][it+1] >0) res = (res + dfs(i, it+1, v+1))%mod}
                    dp[i][j][v] = res
                    res
                }
            }

        return dfs(0,0,1).toInt()
    }

}
