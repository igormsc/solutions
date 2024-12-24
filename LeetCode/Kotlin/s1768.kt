class Solution1768 {
    fun mergeAlternately(word1: String, word2: String): String {
        var (i, j) = 0 to 0
        return buildString {
            while (i < word1.length && j < word2.length) {
                append(word1[i++])
                append(word2[j++])
            }
            append(word1.slice(i..word1.lastIndex))
            append(word2.slice(i..word2.lastIndex))
        }
    }
}
