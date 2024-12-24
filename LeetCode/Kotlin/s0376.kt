class Solution376 {
    fun wiggleMaxLength(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        val (up, down) = IntArray(n).also { it[0] = 1 } to IntArray(n).also { it[0] = 1 }
        (1..<n).forEach { i ->
            when {
                nums[i] > nums[i - 1] -> {
                    up[i] = down[i - 1] + 1
                    down[i] = down[i - 1]
                }

                nums[i] < nums[i - 1] -> {
                    down[i] = up[i - 1] + 1
                    up[i] = up[i - 1]
                }

                else -> {
                    down[i] = down[i - 1]
                    up[i] = up[i - 1]
                }
            }
        }
        return maxOf(up.last(), down.last())
    }
}
