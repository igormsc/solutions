class Solution3106 {
    fun getSmallestString(s: String, k: Int): String {
        val s = s.toCharArray()
        var k = k
        var i = 0
        while (i<s.size && k>0) {
            val d = minOf(s[i].code - 'a'.code, 'z'.code - s[i].code + 1)
            s[i] = if (d<=k) 'a' else (s[i].code - k).toChar()
            k -= d
            i++
        }
        return s.joinToString("")
    }
}

