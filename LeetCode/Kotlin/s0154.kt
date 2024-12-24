class Solution154 {
    fun findMin(nums: IntArray): Int {
        var (l, r) = 0 to nums.lastIndex
        while (l<r) {
            val m = (l+r)/2
            if (nums[m]>nums[r]) l = m+1
            else if (nums[m]<nums[r]) r = m else --r
        }
        return nums[l]
    }
}
