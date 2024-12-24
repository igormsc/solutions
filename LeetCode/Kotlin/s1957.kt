class Solution1957 {
    fun makeFancyString(s: String): String {
        val r = s.toCharArray()
        var j = 2
        (2..r.lastIndex).forEach { i ->
            if (r[i] != r[j - 1] || r[i] != r[j - 2]) r[j++] = r[i]
        }
        return r.slice(0..<maxOf(j,r.size)).joinToString("")
    }
}

