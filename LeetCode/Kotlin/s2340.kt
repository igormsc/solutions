class Solution2340 {
    fun minimumSwaps(nums: IntArray): Int {
        val n = nums.size
        var (i, j) = 0 to 0
        for (k in 0..<n) {
            if (nums[k] < nums[i] || (nums[k] == nums[i] && k < i)) i = k
            if (nums[k] > nums[j] || (nums[k] == nums[j] && k > j)) j = k
        }
        return if (i == j)  0 else i + n - 1 - j - (if (i > j) 1 else 0)
    }
}