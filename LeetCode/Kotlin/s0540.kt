class Solution540 {
    fun singleNonDuplicate(nums: IntArray): Int {
        var (l, r) = 0 to nums.lastIndex
        while (l < r) {
            val m = l + (r - l) / 2
            val f = (r - m) % 2 == 0
            when {
                nums[m] == nums[m+1] ->
                    if (f) l = m+2 else r = m-1
                nums[m] == nums[m-1] ->
                    if (f) r = m-2 else l = m+1
                else -> return nums[m]
            }
        }
        return nums[l]
    }
}
