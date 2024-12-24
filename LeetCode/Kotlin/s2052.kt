class Solution2052 {
    fun minimumCost(sentence: String, k: Int): Int {
        val words = sentence.split(" ")
        val n = words.size
        val d = Array<Int?>(n){null}
        val s = IntArray(n + 1)
        for (i in 0..<n)
            s[i + 1] = s[i] + words[i].length

        fun dfs(i: Int): Int {
            if (s[n] - s[i] + n - i - 1 <= k) return 0
            if (d[i] != null) return d[i]!!

            var res = Int.MAX_VALUE
            var j = i + 1
            while (j < n && s[j] - s[i] + j - i - 1 <= k) {
                val m = s[j] - s[i] + j - i - 1
                res = minOf(res, (dfs(j++) + (k - m) * (k - m)))
            }
            return res.also { d[i] = it }
        }

        return dfs(0)
    }

}