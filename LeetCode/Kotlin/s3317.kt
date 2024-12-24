class Solution3317 {

    fun numberOfWays(n: Int, x: Int, y: Int): Int {
        val MOD = 1_000_000_007L
        val s = Array(1001) { LongArray(1001) }.also{it[0][0] = 1L}
        for (i in 1..1000)
            for (j in 1..i)
                s[i][j] = (s[i - 1][j - 1] + s[i - 1][j] * j) % MOD
        var (res, perm, pow) = longArrayOf(0,1,1)
        for (i in 1..minOf(n,x)) {
            perm = perm * (x - i + 1) % MOD
            pow = pow * y % MOD
            res = (res + perm * s[n][i] % MOD * pow) % MOD
        }
        return res.toInt()
    }

}