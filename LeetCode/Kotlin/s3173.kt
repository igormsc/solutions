class Solution3173 {
    fun orArray(nums: IntArray): IntArray {
        val n = nums.size
        val res = IntArray(n - 1)
        for (i in 0..<n - 1)
            res[i] = nums[i] or nums[i + 1]
        return res
    }

}