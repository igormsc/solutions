class Solution3183 {
    private val MOD = 1_000_000_007
    private val m = 100_001
    private val cons = intArrayOf(1, 2, 6)
    private val f = IntArray(m).also {it[0]=1}

    init {
        for (x in cons)
            for (j in x..<m)
                f[j] = (f[j] + f[j - x]) %MOD
    }

    fun numberOfWays(n: Int): Int {
        var res: Int =f[n]
        if (n >= 4) res = (res + f[n - 4]) % MOD
        if (n >= 8) res = (res + f[n - 8]) % MOD
        return res
    }

}