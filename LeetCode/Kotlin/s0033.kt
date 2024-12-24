class Solution033 {
    fun search(nums: IntArray, target: Int): Int {
        val n = nums.size
        var (l, r) = 0 to nums.lastIndex
        while (l < r) {
            val m = (l+r)/2
            if (nums[0]<=nums[m])
                if (nums[0] <= target && target <= nums[m]) r = m else l = m+1
            else
                if (nums[m]<target && target<=nums[n-1]) l = m+1 else r = m
        }
        return if (nums[l]==target) l else -1
    }
}