class Solution3398 {
    fun minLength(s: String, numOps: Int): Int {
        val n = s.length
        var (l, r)  = 1 to n
        while (l <= r) {
            val m = (r + l) / 2
            val cnt = if (m == 1) minOf(s.withIndex().count { it.value.code.and(1) != it.index.and(1) },
                                        s.withIndex().count { it.value.code.and(1) == it.index.and(1) })
                        else {
                                var (i, x) = 0 to 0
                                while (i < n)
                                    ((i+1..<n).takeWhile{ s[it] == s[i] }.count() + 1).also {
                                        i += it
                                        x += it / (m + 1) }
                            x }
            if (cnt <= numOps) r = m - 1 else l = m + 1
        }
        return l
    }
}
