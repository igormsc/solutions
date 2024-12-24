class Solution1371 {
    private val cM = IntArray(26).also{it[0]=1;it[4]=2;it[8]=4;it[14]=8;it[20]=16}
    fun findTheLongestSubstring(s: String): Int {
        val m = IntArray(32) {-1}
        var msk = 0
        return s.foldIndexed(0){ i,r, c ->
            msk = msk xor cM[c.code-'a'.code]
            if (msk != 0 && m[msk] == -1) m[msk] = i
            maxOf(r, i-m[msk]) }
    }
}
