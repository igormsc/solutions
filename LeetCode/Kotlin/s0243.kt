import kotlin.math.absoluteValue

class Solution243 {
    fun shortestDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
        var res = Int.MAX_VALUE/2
        var (i, j) = -1 to -1
        wordsDict.forEachIndexed { k, w ->
            if (w == word1) i = k
            if (w == word2) j = k
            if (i != -1 && j != -1) res = minOf(res, (i-j).absoluteValue)
        }
        return res
    }
}