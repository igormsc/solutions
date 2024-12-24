class Solution3137 {
    fun minimumOperationsToMakeKPeriodic(word: String, k: Int): Int {
        val m = mutableMapOf<String, Int>()
        for (i in 0..word.lastIndex step k) {
            val s = word.substring(i, minOf(i+k, word.length))
            m[s] = (m[s]?:0) + 1
        }
        return word.length / k - m.values.max()
    }
}
