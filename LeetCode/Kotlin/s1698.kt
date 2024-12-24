class Solution1698 {
    fun countDistinct(s: String): Int {
        val base = 131
        val n = s.length
        val p = LongArray(n + 10).also { it[0] = 1 }
        val h = LongArray(n + 10)
        for (i in 0..<n) {
            p[i + 1] = p[i] * base
            h[i + 1] = h[i] * base + s[i].code.toLong()
        }
        val set = mutableSetOf<Long>()
        for (i in 1..n)
            for (j in i..n) {
                val t = h[j] - h[i - 1] * p[j - i + 1]
                set.add(t)
            }
        return set.size
    }
}