class Solution2516 {
    fun takeCharacters(s: String, k: Int): Int {
        val cnt = s.fold(IntArray(255)) { r, c -> r[c.code]++; r }
        return if (minOf(cnt['a'.code], cnt['b'.code], cnt['c'.code]) < k) return -1
                else {
                    var j = 0
                    s.indices.fold(-1) { r, i ->
                        if (--cnt[s[i].code] < k)
                            while (cnt[s[i].code] < k) cnt[s[j++].code]++
                        maxOf(r, i - j + 1)
                    }.let { s.length - it }
                }
    }
}
