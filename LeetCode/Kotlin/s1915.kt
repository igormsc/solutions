class Solution1915 {
    fun wonderfulSubstrings(word: String): Long {
        val cnt = IntArray(1024).also { it[0] = 1 }
        var mask = 0
        var res = 0L
        word.forEach { c ->
            mask = mask.xor(1 shl(c.code -'a'.code))
            res += cnt[mask]
            (0..<10).forEach { res +=cnt[mask.xor(1 shl it)] }
            cnt[mask]++
        }
        return res
    }
}
