class Solution3176 {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val dp = Array(k+1) { mutableMapOf<Int,Int>() }
        val res = IntArray(k+1)
        nums.forEach{ n ->
            (k downTo 0).forEach {i ->
                dp[i][n] = maxOf((dp[i][n]?:0)+1, if (i>0) res[i-1] + 1 else 0 )
                res[i] = maxOf(res[i], dp[i][n]?:0)
            }
        }
        return res[k]
    }
}
