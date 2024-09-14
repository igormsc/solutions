class Solution3254 {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        val res = IntArray(nums.size + 1 - k) { -1 }
        var p = 0
        nums.indices.forEach { i ->
            p = if (i > 0 && nums[i - 1] == nums[i] - 1) p + 1 else 0
            if (p + 1 >= k) res[i - k + 1] = nums[i]
        }
        return res
    }
}