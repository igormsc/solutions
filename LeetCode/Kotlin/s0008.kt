class Solution008 {
    fun myAtoi(s: String): Int {
        if (s.isEmpty()) return 0
        var r = 0L
        var i = 0
        while (i <= s.lastIndex) {
            if (s[i] != ' ') break
            i++
        }
        if (i > s.lastIndex) return 0
        val sign = if (s[i] == '-') -1L else 1L
        if (s[i] =='-' || s[i] == '+') i++
        while (i <= s.lastIndex) {
            if (s[i].isDigit()) {
                r *=10L
                r += (s[i].code-'0'.code).toLong()
            } else break
            if (r >= 2147483647 && sign > 0) return 2147483647
            if (r >= 2147483648) return -2147483648
            i++
        }
        return (r*sign).toInt()
    }
}
