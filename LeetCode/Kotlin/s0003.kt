class Solution003 {
    fun lengthOfLongestSubstring(s: String): Int {
        val d = IntArray(255) {-1}
        var (mx, start) = 0 to -1
        s.indices.forEach { i ->
            if (d[s[i].code] > start) start = d[s[i].code]
            d[s[i].code] = i
            if (mx<i-start) mx = i-start
        }
        return mx
    }
}