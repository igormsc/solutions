class Solution1099 {
    fun twoSumLessThanK(nums: IntArray, k: Int): Int {
        nums.sort()
        var res = -1
        var (i, j) = 0 to nums.lastIndex
        while (i < j) {
            val s = nums[i] + nums[j]
            if (s < k) {
                res = maxOf(res, s)
                i++
            } else j--
        }
        return res
    }

}