class Solution3302 {
    fun validSequence(word1: String, word2: String): IntArray {
        val (n,m) = word1.length to word2.length
        val last = IntArray(m){-1}
        var j = m - 1
        (n-1 downTo 0).forEach{ i -> if (j >= 0 && word1[i] == word2[j]) last[j--] = i}
        var i = 0
        j = 0
        val res = IntArray(m)
        var cnt = 0
        while (i < n && j < m) {
            if (word1[i] == word2[j] || (cnt == 0 && (j == m - 1 || i < last[j + 1]))) {
                res[j] = i
                cnt += if ((word1[i] != word2[j])) 1 else 0
                j++
            }
            i++
        }
        return if (j == m) res else IntArray(0)
    }
}
