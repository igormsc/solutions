class Solution3090 {
    fun maximumLengthSubstring(s: String): Int {
        val cnt = IntArray(255)
        var j = 0
        return s.foldIndexed(0) { i, r, c ->
                    cnt[c.code]++
                    while (cnt[c.code] > 2) cnt[s[j++].code]--
                    maxOf(r, i - j + 1) }
    }

}

