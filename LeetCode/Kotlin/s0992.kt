class Solution992 {
    fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
        val m = IntArray(nums.size + 1)
        var cnt = 0
        var j = 0
        var p = 0
        return nums.sumOf { n ->
                                if (m[n]++ == 0) cnt++
                                m[n]++
                                if (cnt > k) {
                                    m[nums[j++]]--
                                    cnt--
                                    p = 0
                                }
                                while (m[nums[j]] > 1) {
                                    m[nums[j++]]--
                                    p++
                                }
                                if (cnt == k) p + 1 else 0
                            }
    }
}
