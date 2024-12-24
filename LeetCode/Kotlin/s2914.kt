class Solution2914 {
    fun minChanges(s: String): Int = (0..s.lastIndex step 2).count{ s[it] != s[it+1] }
}
