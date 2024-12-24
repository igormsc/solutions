class Solution3114 {
    fun findLatestTime(s: String): String = s.let {
        val b = it.toCharArray()
        b[4] = if (b[4] == '?') '9' else b[4]
        b[3] = if (b[3] == '?') '5' else b[3]
        b[1] = if (b[1] == '?') if (b[0] == '0') '9' else '1' else b[1]
        b[0] = if (b[0] == '?') if (b[1] == '0' || b[1] == '1') '1' else '0' else b[0]
        b.joinToString("") }
}
