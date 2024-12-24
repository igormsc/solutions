class Solution161 {
    fun isOneEditDistance(s: String, t: String): Boolean {
        val (s, t) = if (s.length > t.length) s to t else t to s
        val (m, n) = s.length to t.length
        if (m - n > 1) return false
        t.indices.forEach { i ->
            if (s[i] != t[i])
                return (m == n && s.substring(i + 1) == t.substring(i + 1)) || s.substring(i + 1) == t.substring(i) }
        return m == n + 1
    }
}