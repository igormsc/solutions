class Solution1692 {
    fun waysToDistribute(n: Int, k: Int): Int {
        val MOD = 1_000_000_007
        val f = Array(n + 1) { IntArray(k + 1) }.also { it[0][0] = 1 }
        for (i in 1..n)
            for (j in 1..k)
                f[i][j] = (f[i - 1][j].toLong() * j % MOD + f[i - 1][j - 1]).toInt() % MOD
        return f[n][k]
    }

}