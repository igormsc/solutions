class Solution3298 {
    fun validSubstringCount(word1: String, word2: String): Long {
        val cnt = IntArray(128)
        var k = word2.length
        var res = 0L
        var i = 0

        word2.forEach { cnt[it.code]++ }

        word1.indices.forEach { j ->
            if (cnt[word1[j].code]-- > 0) k--
            while (k == 0 && cnt[word1[i].code] < 0) cnt[word1[i++].code]++
            if (k == 0) res += (i + 1).toLong()
        }
        return res
    }
}
