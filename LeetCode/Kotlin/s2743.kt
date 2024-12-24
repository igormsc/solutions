class Solution2743 {
    fun numberOfSpecialSubstrings(s: String): Int {
        var j = 0
        val cnt = IntArray(255)
        return s.indices.sumOf { i ->
            val c = s[i].code
            cnt[c]++
            while (cnt[c] > 1) cnt[s[j++].code]--
            i - j + 1
        }
    }

}