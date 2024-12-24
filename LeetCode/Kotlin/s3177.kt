class Solution3177 {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val dp = Array(k+1) { mutableMapOf<Int,Int>() }
        return nums.fold(IntArray(k+1)) { r, n ->
                    (k downTo 0).forEach{ i ->
                        dp[i][n] = maxOf((dp[i][n]?:0) + 1, if (i>0) r[i-1]+1 else 0 )
                        r[i] = maxOf(r[i], (dp[i][n]?:0))}
                    r }[k]
    }
}
