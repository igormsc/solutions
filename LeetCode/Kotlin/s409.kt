class Solution409 {
    fun longestPalindrome(s: String): Int = s
        .fold(IntArray(52)) { r, c -> r[c.code - if (c<='Z') 'A'.code else 'a'.code - 26 ]++; r}
        .fold(0 to false) { (ln, o), c -> ln + c/2 to if (c%2 == 1) true else o }.let { it.first * 2 + if (it.second) 1 else 0 }
}
