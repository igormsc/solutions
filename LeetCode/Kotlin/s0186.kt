class Solution186 {
    fun reverseWords(s: CharArray): Unit {
        var i = 0
        s.indices.forEach { j ->
            if (s[j] == ' ') {
                s.reverse(i,j)
                i = j + 1
            } else if (j == s.lastIndex && i!=j) s.reverse(i, j+1)
        }
        s.reverse()
    }
}
