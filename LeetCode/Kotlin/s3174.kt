class Solution3174 {
    fun clearDigits(s: String): String {
        var j = 0
        val s = s.toCharArray()
        s.forEach { c -> if (c.isDigit()) j-- else s[j++] = c }
        return s.slice(0..j).joinToString("")
    }
}
