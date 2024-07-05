class Solution2486 {
    fun appendCharacters(s: String, t: String): Int {
        var j = 0
        var i = 0
        while (i < s.length && j < t.length) if (s[i++] == t[j]) j++
        return t.length - j
    }
}
