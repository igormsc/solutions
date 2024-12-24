class Solution921 {
    fun minAddToMakeValid(s: String): Int {
        var (l,r) = 0 to 0
        s.forEach { c ->
            when {
                c == '(' -> r++
                r > 0 -> r--
                else -> l++
            }
        }
        return l + r
    }
}
