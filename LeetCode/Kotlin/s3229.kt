class Solution3229 {
    fun minimumOperations(nums: IntArray, target: IntArray): Long {
        var res = 0L
        var pre = 0
        nums.indices.forEach { i ->
            res += maxOf(target[i] - nums[i] - pre,0)
            pre = target[i] - nums[i]
        }
        return res + maxOf(0, -pre)
    }
}