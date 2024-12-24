class Solution3163 {
    fun compressedString(word: String): String {
        var (i, j) = 0 to 0
        val res = StringBuilder()
        while (j < word.length) {
            var cnt = 0
            while (j < word.length && word[i] == word[j] && cnt < 9) {j++; cnt++}
            res.append(cnt).append(word[i])
            i = j
        }
        return res.toString()
    }
}
