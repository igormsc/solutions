class Solution1473 {
    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        val dp = Array(m) { Array(n+1) { IntArray(target+1) { Int.MAX_VALUE/2 } } }
        if (houses[0] == 0) (1..n).forEach { dp[0][it][1] = cost[0][it - 1] } else dp[0][houses[0]][1] = 0

        for (i in 1..<m)
            if (houses[i] == 0)
                (1..n).forEach { j ->
                    (1..minOf(target, i + 1)).forEach { k ->
                        (1..n).forEach { dp[i][j][k] = if (j == it) minOf(dp[i][j][k], dp[i - 1][j][k] + cost[i][j - 1]) else  minOf(dp[i][j][k], dp[i - 1][it][k - 1] + cost[i][j - 1]) } } }
            else {
                val j = houses[i]
                (1..minOf(target, i + 1)).forEach { k ->
                    (1..n).forEach { dp[i][j][k] = if (j == it) minOf(dp[i][j][k], dp[i - 1][j][k]) else minOf(dp[i][j][k], dp[i - 1][it][k - 1]) } } }

        return (1..n).minOf { dp[m - 1][it][target] }.let { if (it >= Int.MAX_VALUE/2) -1 else it }
    }
}
