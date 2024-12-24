class Solution3320 {
    fun countWinningSequences(s: String): Int {
        val sz = s.length
        val MOD = 1_000_000_007
        val dp = Array(2){Array(2001){LongArray(3)} }.also{it[0][1000][0]=1}
        (s.indices).forEach { i ->
            val a = when (s[i]) {
                'F' -> 2
                'E' -> 1
                else -> 0
            }
            (0..2).forEach{ b ->
                val pt =
                    when {
                        a == b -> 0
                        a == 0 && b == 2 -> -1
                        b == 0 && a == 2 -> 1
                        a > b  -> -1
                        else -> 1
                    }
                (1000-i..1000+i).forEach { j -> dp[if (i%2==0) 1 else 0][j + pt][b] = (dp[i % 2][j][0] + dp[i % 2][j][1] + dp[i % 2][j][2] - (if (i == 0)  0 else dp[i % 2][j][b])) % MOD } }
        }
        return (1001..1000+s.length).fold(0L) { r, j -> (dp[sz % 2][j][0] + dp[sz % 2][j][1] + dp[sz % 2][j][2] + r) % MOD }.toInt()
    }
}
