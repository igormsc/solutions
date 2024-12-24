import kotlin.math.absoluteValue

class Solution245 {
    fun shortestWordDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
        var res = wordsDict.size
        if (word1 == word2) {
            var j = -1
            wordsDict.forEachIndexed { i, w ->
                if (w == word1) {
                    if (j != -1) res = minOf(res, i - j)
                    j = i
                }
            }
        } else {
            var (i, j) = -1 to -1
            wordsDict.forEachIndexed { k, w ->
                if (w == word1) i = k
                if (w == word2) j = k
                if (i != -1 && j != -1) res = minOf(res, (i - j).absoluteValue)
            }
        }
        return res
    }

}