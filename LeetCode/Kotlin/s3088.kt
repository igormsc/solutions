class Solution3088 {
    fun makeAntiPalindrome(s: String): String {
        val cs = s.toCharArray()
        cs.sort()
        val n = cs.size
        val m = n / 2
        if (cs[m] == cs[m - 1]) {
            var i = m
            while (i < n && cs[i] == cs[i - 1]) i++
            var j = m
            while (j < n && cs[j] == cs[n - j - 1]) {
                if (i >= n) return "-1"
                val t = cs[i]
                cs[i++] = cs[j]
                cs[j++] = t
            }
        }
        return cs.joinToString("")
    }

}