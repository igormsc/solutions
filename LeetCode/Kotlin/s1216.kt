class Solution1216 {
    fun isValidPalindrome(s: String, k: Int): Boolean {
        val n = s.length
        val f = Array(n) { IntArray(n) }
        (0..<n).forEach{ f[it][it] = 1 }

        for (i in n - 2 downTo 0)
            for (j in i + 1..<n) {
                if (s[i] == s[j]) f[i][j] = f[i + 1][j - 1] + 2
                else f[i][j] = maxOf(f[i + 1][j], f[i][j - 1])
                if (f[i][j] + k >= n) return true
            }
        return false
    }

}