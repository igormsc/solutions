class Solution2370 {
    fun longestIdealString(s: String, k: Int): Int =
        s.fold(0 to IntArray('z'.code+26)) { (r, dp), c ->
            val c = c.code
            (c-k..c+k).forEach { dp[c] = maxOf(dp[c], dp[it]) }
            maxOf(r, ++dp[c]) to dp }.first

}
