class Solution552 {
    fun checkRecord(n: Int): Int {
        val MOD = 1_000_000_007

        if (n==1) return 3

        val a = IntArray(if (n<3) 3 else n).also { it[0] = 1; it[1] = 2; it[2] = 4 }
        val p = IntArray(if (n<2) 2 else n).also { it[0]=1 }
        val l = IntArray(if (n<1) 1 else n).also { it[0] = 1; it[1] = 3 }

        (1..<n).forEach {
            p[it] = ((a[it-1]+p[it-1])%MOD + l[it-1]) % MOD
            if (it > 1) l[it] = ((a[it-1]+p[it-1])%MOD + (a[it-2]+p[it-2])%MOD) % MOD
            if (it > 2) a[it] = ((a[it-1]+a[it-2])%MOD + a[it-3]) % MOD
        }

        return ((a[n-1]+p[n-1])%MOD + l[n-1]%MOD)%MOD
    }
}
