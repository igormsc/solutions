class Solution1966 {
    fun binarySearchableNumbers(nums: IntArray): Int {
        val n = nums.size
        val r = BooleanArray(n) { true }
        var mx = Int.MIN_VALUE/2
        var mn = Int.MAX_VALUE/2
        (0..<n).forEach { i ->
            if (nums[i] < mx) r[i] = false
            mx = maxOf(mx, nums[i])
        }
        return (n - 1 downTo 0).count { i ->
                    if (nums[i] > mn) r[i] = false
                    mn = minOf(mn, nums[i])
                    r[i] }
    }

}