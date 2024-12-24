class Solution035 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var (l, r) = 0 to nums.lastIndex
        while (l <= r) {
            val m = (l+r)/2
            if (nums[m] < target) l = m+1 else r = m - 1
        }
        return l
    }
}