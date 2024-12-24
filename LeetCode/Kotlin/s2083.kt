class Solution2083 {
    fun numberOfSubstrings(s: String): Long {
        val cnt = LongArray(255)
        return s.sumOf { ++cnt[it.code] }
    }

}