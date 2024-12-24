class Solution159 {
    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        val cnt = mutableMapOf<Char, Int>()
        var j = 0
        return s.foldIndexed(0) { i, r, c ->
            cnt[c] = (cnt[c] ?: 0) + 1
            while (cnt.size > 2) {
                val x = s[j++]
                cnt[x] = cnt[x]!! - 1
                if (cnt[x] == 0) cnt.remove(x)
            }
            maxOf(r, (i - j + 1)) }
    }
}