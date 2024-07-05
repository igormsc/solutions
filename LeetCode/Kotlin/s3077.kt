class Solution3077 {
    fun maximumStrength(nums: IntArray, k: Int): Long {
        val n = nums.size
        val dp = Array(n+1) { LongArray(k+1) { Long.MIN_VALUE/2} }.also { a -> a.indices.forEach { i -> a[i][0] = 0 } } to
                 Array(n+1) { LongArray(k+1) { Long.MIN_VALUE/2} }.also { a -> a.indices.forEach { i -> a[i][0] = 0 } }

        fun coeff(j: Int) = ((k-j+1) * (if(j%2==1) 1 else -1)).toLong()

        (1..n).forEach { i ->
            (1..k).forEach { j ->
               dp.first[i][j] = maxOf(dp.second[i-1][j-1], dp.first[i-1][j])+nums[i-1]*coeff(j)
                dp.second[i][j] = maxOf(dp.second[i-1][j], dp.first[i][j])
            }
        }
        return dp.second[n][k]
    }

}
