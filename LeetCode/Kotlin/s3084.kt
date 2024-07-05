class Solution3084 {
    fun countSubstrings(s: String, c: Char): Long = s.count { it == c }.let{ it.toLong() * (it.toLong() + 1L) / 2L }

}

