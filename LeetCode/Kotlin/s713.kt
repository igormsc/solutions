class Solution713 {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var p = 1
        var i = 0
        return nums.withIndex().sumOf { (j, n) ->
            p *= n
            while (i <= j && p >= k) p /= nums[i++]
            j - i + 1
        }
    }

}
