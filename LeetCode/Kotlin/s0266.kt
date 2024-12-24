class Solution266 {
    fun canPermutePalindrome(s: String): Boolean {
        val cnt = IntArray(26)
        for (c in s.toCharArray()) cnt[c.code - 'a'.code]++
        return cnt.count { it%2==1 } < 2
    }

}