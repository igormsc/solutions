import kotlin.math.absoluteValue

class WordDistance(wordsDict: Array<String>) {

    private val m: MutableMap<String, MutableList<Int>> = HashMap()

    init {
        wordsDict.forEachIndexed { i, w -> m.computeIfAbsent(w) { mutableListOf() }.add(i) }
    }

    fun shortest(word1: String, word2: String): Int {
        val (a, b) = m[word1]!! to m[word2]!!
        var res = Int.MAX_VALUE/2
        var (i, j) = 0 to 0
        while (i < a.size && j < b.size) {
            res = minOf(res, (a[i] - b[j]).absoluteValue)
            if (a[i] <= b[j]) i++ else j++
        }
        return res
    }


}