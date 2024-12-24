class Solution2330 {
    fun makePalindrome(s: String): Boolean {
        var cnt = 0
        var (i, j) = 0 to s.lastIndex
        while (i < j) if (s[i++] != s[j--]) cnt++
        return cnt <= 2
    }

}