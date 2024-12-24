class Solution344 {
    fun reverseString(s: CharArray): Unit {
        (0..s.lastIndex/2).forEach { i -> s[i] = s[s.lastIndex-i].also { s[s.lastIndex-i] = s[i] } }
    }
}
