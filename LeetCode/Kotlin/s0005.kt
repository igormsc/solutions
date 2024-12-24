class Solution005 {
    fun longestPalindrome(s: String): String {
        val n = s.length
        val dp = Array(n) { BooleanArray(n) {true} }
        var mx = 1
        var k = 0
        for (i in n - 2 downTo 0)
            for (j in i + 1..<n) {
                dp[i][j] = false
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1]
                    if (dp[i][j] && mx < j - i + 1) {
                        mx = j - i + 1
                        k = i
                    }
                }
            }
        return s.substring(k, k + mx)
    }
}