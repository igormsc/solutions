class Solution3101 {
    fun countAlternatingSubarrays(nums: IntArray): Long =
        nums.drop(1).foldIndexed(1L to 1) { i, (r, s), n ->
            (if (nums[i] == n) 1 else s+1).let { r+it.toLong() to it } }.first

}
