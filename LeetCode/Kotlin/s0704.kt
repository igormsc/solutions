class Solution704 {
    fun search(nums: IntArray, target: Int): Int {
        var (l, r) = 0 to nums.lastIndex
        while (l <= r) {
            val m = (l + (r-l)/2)
            if (nums[m] == target) return m
            if (nums[m] > target) r=m-1 else l=m+1
        }
        return -1
    }
}
