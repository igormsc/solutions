class Solution1682 {
    fun longestPalindromeSubseq(s: String): Int {
        val n = s.length
        val f = Array(n) { Array(n) { IntArray(27) {-1} } }

        fun dfs(i: Int, j: Int, x: Int): Int {
            if (i >= j) return 0
            if (f[i][j][x] != -1) return f[i][j][x]

            val r = if (s[i] == s[j] && s[i].code - 'a'.code != x) dfs(i + 1, j - 1, s[i].code - 'a'.code) + 2
            else maxOf(dfs(i + 1, j, x), dfs(i, j - 1, x))
            f[i][j][x] = r
            return r
        }

        return dfs(0, n - 1, 26)
    }

}