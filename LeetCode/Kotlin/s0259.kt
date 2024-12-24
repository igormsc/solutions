class Solution259 {
    fun threeSumSmaller(nums: IntArray, target: Int): Int {
        nums.sort()
        var res = 0
        nums.indices.forEach { i ->
            var (j,k) = i + 1 to nums.lastIndex
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] >= target) k--
                else res += k - j++
            }
        }
        return res
    }

}