class Solution2218 {
    fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
        val ps = mutableListOf<IntArray>()
        piles.forEach { p -> ps.add(p.indices.fold(IntArray(p.size + 1)) { r, i -> r[i + 1] = r[i] + p[i]; r}) }
        val dp = IntArray(k + 1)
        for (s in ps)
            for (j in k downTo 0)
                for (i in s.indices)
                    if (j >= i) dp[j] = maxOf(dp[j], dp[j - i] + s[i])
        return dp[k]
    }
}
