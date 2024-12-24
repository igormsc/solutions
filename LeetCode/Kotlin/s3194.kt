class Solution3194 {
    fun minimumAverage(nums: IntArray): Double {
        nums.sort()
        var l = 0
        var r = nums.lastIndex
        var res = Int.MAX_VALUE.toDouble()
        while (l < r) res = minOf(res, (nums[l++].toDouble() + nums[r--].toDouble()) / 2)
        return res
    }
}
