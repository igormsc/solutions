class Solution920 {
    fun numMusicPlaylists(n: Int, goal: Int, k: Int): Int {
        val mod = 1_000_000_007L
        val dp = Array(n+1) {LongArray(goal+1)}
        fun factorial(n: Int): Long = (1..n).fold(1) { r, i -> (r*i) % mod}

        (k+1..n).forEach { i ->
            (i..goal).forEach { j -> dp[i][j] = if (i==j || (i==k+1)) factorial(i) else (dp[i-1][j-1]*i + dp[i][j-1]*(i-k))%mod } }

        return dp[n][goal].toInt()
    }
}
