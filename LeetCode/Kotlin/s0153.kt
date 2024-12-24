class Solution153 {
    fun findMin(nums: IntArray): Int {
        var (l, r) = 0 to nums.lastIndex
        while (l<r) {
            if (nums[l]<nums[r]) return nums[l]
            val m = (l+r)/2
            if (nums[m]>nums[r]) l = m+1 else r = m
        }
        return nums[l]
    }
}
