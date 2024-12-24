class Solution408 {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        val (m, n) = word.length to abbr.length
        var (i, j, x) = intArrayOf(0,0,0)
        while (i < m && j < n) {
            val c = abbr[j]
            if (c.isDigit()) {
                if (c == '0' && x == 0) return false
                x = x * 10 + (c.code - '0'.code)
            } else {
                i += x
                x = 0
                if (i >= m || word[i] != c) return false
                i++
            }
            j++
        }
        return i + x == m && j == n
    }

}