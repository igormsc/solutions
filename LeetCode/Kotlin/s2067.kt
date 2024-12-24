class Solution2067 {
    fun equalCountSubstrings(s: String, count: Int): Int {
            var res = 0
            val cnt = IntArray(26)
            val n = s.length
            var i = 1
            while (i < 27 && i * count <= n) {
                val k = i * count
                cnt.fill(0)
                var t = 0
                for (j in 0..<n) {
                    val c = s[j].code - 'a'.code
                    cnt[c]++
                    if (cnt[c] == count) t++
                    if (cnt[c] == count + 1) t--
                    if (j - k >= 0) {
                        val c = s[j - k].code - 'a'.code
                        cnt[c]--
                        if (cnt[c] == count) t++
                        if (cnt[c] == count - 1) t--
                    }
                    if (i == t) res++
                }
                i++
            }
            return res
        }

}