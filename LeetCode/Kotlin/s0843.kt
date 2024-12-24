class Solution843 {
    fun findSecretWord(words: Array<String>, master: Master) {
        var res = 0
        val p = Array(6) { LongArray(26) }
        val rmWords = mutableListOf<String>()
        words.forEach { w ->
            rmWords.add(w)
            (0..5).forEach { p[it][w[it].code-'a'.code]++ }
        }

        fun best(words: MutableList<String>): String {
            var cur = 0L
            var best = ""
            words.forEach { w ->
                val score = (0..5).fold(1L) { r, i -> r * p[i][w[i].code - 'a'.code] }
                if (score > cur) cur = score.also { best = w }
            }
            return best
        }

        while (res < 6) {
            val candidate = best(rmWords)
            res = master.guess(candidate)
            var j = 0
            while (j<rmWords.size) {
                if (match(rmWords[j], candidate) != res) {
                    (0..5).forEach { p[it][rmWords[j][it].code - 'a'.code]-- }
                    rmWords.removeAt(j)
                } else j++
            }
        }

    }

    private fun match(w1: String, w2: String) = w1.indices.count { w1[it] == w2[it] }
}

abstract class Master {
    abstract fun guess(word: String): Int
}
