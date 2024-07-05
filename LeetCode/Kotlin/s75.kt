class Solution75 {
    fun sortColors(nums: IntArray): Unit {
        var i = 0
        var j = 0
        var k = nums.lastIndex
        while (j<=k) {
            when (nums[j]) {
                0 -> nums[i] = nums[j].also { nums[j++] = nums[i++] }
                1 -> j++
                else -> nums[k] = nums[j].also { nums[j] = nums[k--] }
            }
        }
    }
}
