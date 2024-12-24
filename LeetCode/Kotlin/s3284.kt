class Solution3284 {
    fun getSum(nums: IntArray): Int {
        var (sum1,sum2) = nums[0].toLong() to nums[0].toLong()
        var res = nums[0].toLong()
        var (cnt1,cnt2) = 1L to 1L
        (1..nums.lastIndex).forEach { i ->
            if (nums[i]-nums[i-1] != 1) {sum1 = 0; cnt1 = 0}
            if (nums[i] - nums[i-1] != -1) {sum2 = 0; cnt2 = 0}
            sum1 += ++cnt1 * nums[i]
            sum2 += ++cnt2 * nums[i]
            res = (res + sum1 + sum2 - nums[i].toLong()) % 1_000_000_007L
        }
        return res.toInt()
    }
}
