class Solution1133 {
    fun largestUniqueNumber(nums: IntArray): Int {
        val cnt = nums.fold(IntArray(1001)) { r, n -> r[n]++; r}
        return (1000 downTo 0).find{cnt[it]==1}?:-1
    }
}