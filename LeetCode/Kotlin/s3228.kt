class Solution3228 {
    fun maxOperations(s: String): Int {
        var o = 0
        return s.indices.sumOf { i ->
                    if (s[i] == '1') o++
                    if (i > 0 && s[i] < s[i - 1]) o else 0 }
    }
}

