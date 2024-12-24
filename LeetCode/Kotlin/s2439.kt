class Solution2439 {
    fun minimizeArrayValue(nums: IntArray): Int {
        var sum = 0L
        return nums.indices.maxOf { i ->
                                        sum += nums[i].toLong()
                                        val i = i.toLong()
                                        (sum + i) / (i + 1L) }.toInt()
    }
}
