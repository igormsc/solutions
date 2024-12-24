class Solution2779 {
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        nums.sort()
        var (i, j) = 0 to 0
        while (j < nums.size)
            if (nums[j++] - nums[i] > 2*k) i++
        return j - i
    }
}
