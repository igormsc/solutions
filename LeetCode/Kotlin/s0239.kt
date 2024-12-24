class Solution239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val maxLR =
            (1..<nums.size)
                .fold( Pair(IntArray(nums.size), IntArray(nums.size))
                    .also { it.first[0] = nums[0]; it.second[it.second.lastIndex] = nums.last() }
                ) { m,  i ->
                    val j = nums.size - i - 1
                    m.first[i] = if (i%k == 0) nums[i] else maxOf(m.first[i-1], nums[i])
                    m.second[j] = if (j%k == 0) nums[j] else maxOf(m.second[j+1], nums[j])
                    m
                }
        return (0..nums.size-k)
            .map{i -> maxOf(maxLR.second[i], maxLR.first[i+k-1]) }
            .toIntArray()
    }
}