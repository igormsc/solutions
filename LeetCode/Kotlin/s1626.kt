class Solution1626 {
    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        val players = ages.zip(scores).sortedWith(compareBy<Pair<Int, Int>> { -it.first }.thenBy { -it.second })
        val dp = IntArray(players.size)
        return scores.indices.maxOf { i ->
            val s = players[i].second
            dp[i] = s
            (0..<i).forEach { j -> if (players[j].second >= players[i].second) dp[i] = maxOf(dp[j] + s, dp[i]) }
            dp[i] }
    }
}
