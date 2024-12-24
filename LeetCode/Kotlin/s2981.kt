class Solution2981 {
    fun maximumLength(s: String): Int {
        val mp = Array(26) { IntArray(s.length) }
        var mx = -1
        var i = 0
        while (i < s.length) {
            var j = i
            while (j < s.length && s[j] == s[i]) j++
            var z = 0
            (j-i downTo 1).forEach { k ->
                mp[s[i].code-'a'.code][z] += k
                if (mp[s[i].code-'a'.code][z++] > 2) mx = maxOf(mx, z)
            }
            i = j
        }
        return mx
    }
}
