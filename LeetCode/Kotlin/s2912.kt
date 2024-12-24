class Solution2912 {
    fun numberOfWays(n: Int, m: Int, k: Int, source: IntArray, dest: IntArray): Int {
        val mod = 1_000_000_007
        var f = LongArray(4).also{it[0]=1}
        repeat(k) {
            val g = LongArray(4)
            g[0] = ((n - 1) * f[1] + (m - 1) * f[2]) % mod
            g[1] = (f[0] + (n - 2) * f[1] + (m - 1) * f[3]) % mod
            g[2] = (f[0] + (m - 2) * f[2] + (n - 1) * f[3]) % mod
            g[3] = (f[1] + f[2] + (n - 2) * f[3] + (m - 2) * f[3]) % mod
            f = g
        }
        return  if (source[0] == dest[0]) if (source[1] == dest[1]) f[0].toInt() else f[2].toInt()
        else if (source[1] == dest[1]) f[1].toInt() else f[3].toInt()
    }

}