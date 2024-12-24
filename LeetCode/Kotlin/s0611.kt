class Solution611 {
    fun triangleNumber(nums: IntArray): Int {
        var cnt = 0
        if (nums.size < 3) return cnt
        nums.sort()
        (2..nums.lastIndex).forEach { i ->
            var (l, r) = 0 to i-1
            while (l < r) {
                if (nums[l]+nums[r] > nums[i]) cnt += r-- - l else l++
            }
        }
        return cnt
    }
}
