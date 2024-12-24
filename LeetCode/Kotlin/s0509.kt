class Solution509 {
    fun fib(n: Int): Int =
        if (n < 2) n
        else (2..n).fold(IntArray(n+1).also{it[0]=0; it[1]=1}) { dp, i -> dp[i] = dp[i-1]+dp[i-2]; dp}[n]

}
