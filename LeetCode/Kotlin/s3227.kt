class Solution3227 {
    fun doesAliceWin(s: String): Boolean = s.any { it in charArrayOf('a', 'o', 'e', 'i', 'u')  }
}