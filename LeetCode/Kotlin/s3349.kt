class Solution3349 {
    fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
        var (cnt, mx) = 1 to 0
        return (1..nums.lastIndex)
            .maxOf { i ->
                if (nums[i] > nums[i - 1]) cnt++
                else {
                    mx = cnt
                    cnt = 1
                }
                maxOf(cnt / 2, minOf(mx, cnt))
            }
            .let { it >= k }
    }
}
