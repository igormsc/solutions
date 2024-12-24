class Solution3350 {
    fun maxIncreasingSubarrays(nums: List<Int>): Int {
        var (p, cnt, res) = intArrayOf(1,1,0)
        (1..nums.lastIndex).forEach { i ->
            if (nums[i] > nums[i-1]) cnt++
            res = maxOf(res, cnt/2, minOf(p, cnt))
            if (nums[i-1] >= nums[i]) p = cnt.also {cnt=1}
        }
        return res
    }
}
