class Solution2140 {
    fun mostPoints(questions: Array<IntArray>): Long {
        val n = questions.size
        val dp = LongArray(n+1).also{it[n]=0L}
        for (i in n-1 downTo 0){
            val j = questions[i][1] + i + 1
            if (j<n) dp[i] = questions[i][0].toLong() + dp[j]
            else dp[i] = questions[i][0].toLong()
            dp[i] = maxOf(dp[i], dp[i+1])
        }
        return dp[0]
    }
}
