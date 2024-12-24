class Solution2539 {
    fun countGoodSubsequences(s: String): Int {
        val n = 10001
        val MOD = 1_000_000_007
        val f = LongArray(n).also { it[0]=1 }
        val g = LongArray(n).also { it[0]=1 }

        fun qmi(a: Long, k: Long, p: Long): Long {
            var a = a
            var k = k
            var res = 1L
            while (k != 0L) {
                if ((k and 1L) == 1L)
                    res = res * a % p
                k = k shr 1
                a = a * a % p
            }
            return res
        }

        fun comb(n: Int, k: Int): Long = ((f[n] * g[k] % MOD) * g[n-k]) % MOD

        for (i in 1..<n) {
            f[i] = f[i-1] * i % MOD
            g[i] = qmi(f[i], (MOD - 2).toLong(), MOD.toLong())
        }

        val cnt = IntArray(26)
        var mx = 1
        for (i in s.indices)
            mx = maxOf(mx, ++cnt[s[i].code - 'a'.code])

        var res = 0L
        for (i in 1..mx) {
            var x = 1L
            for (j in 0..25)
                if (cnt[j] >= i)
                    x = x * (comb(cnt[j], i) + 1) % MOD
            res = (res + x - 1) % MOD
        }
        return res.toInt()
    }

}