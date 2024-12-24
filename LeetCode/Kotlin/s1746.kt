class Solution1746 {
    fun maxSumAfterOperation(nums: IntArray): Int {
        var (a,b) = 0 to 0
        return nums.maxOf { n ->
            b = maxOf((maxOf(a, 0) + n * n), b + n)
            a = maxOf(a, 0) + n
            maxOf(a, b)
        }
    }
}