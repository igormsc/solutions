class Solution1048 {
    fun longestStrChain(words: Array<String>): Int {
        val dct = Array(17) { mutableSetOf<String>() }
        words.forEach { dct[it.length].add(it) }
        val dp = mutableMapOf<String, Int>()
        var res = 1
        (16 downTo 1).forEach {i ->
            if (dct[i-1].isNotEmpty()) {
                dct[i].forEach { w ->
                    val m = dp[w]?:1
                    (w.indices).forEach {j ->
                        val p = w.slice(0..<j) + w.slice(j+1..w.lastIndex)
                        if (dct[i-1].contains(p) && m >= (dp[p]?:1)) {
                            dp[p] = m + 1
                            res = maxOf(res, m+1) } } } }
        }
        return res
    }
}
