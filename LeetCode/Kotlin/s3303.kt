class Solution3303 {
    fun minStartingIndex(s: String, pattern: String): Int {
        val (n,m) = s.length to pattern.length
        val z1 = z_function(pattern + s)
        val z2 = z_function((s+pattern).reversed())
        for (i in 0..n - m) if (z1[m + i] + 1 + z2[n - i] >= m) return i
        return -1
    }

    private fun z_function(s: String): IntArray {
        val n = s.length
        var (l, r) = 0 to 0
        val z = IntArray(n)
        for (i in 1..<n) {
            if (i <= r) z[i] = minOf(r - i + 1, z[i - l])
            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) z[i]++
            if (i + z[i] - 1 > r) {
                l = i
                r = i + z[i] - 1
            }
        }
        return z
    }

}
