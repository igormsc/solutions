class Solution2593 {
    fun findScore(nums: IntArray): Long =
        nums.mapIndexed{ i, v -> intArrayOf(i, v) }
            .sortedBy { it[1] }
            .map{ it[0] }
            .sumOf { i ->
                if (nums[i] != 0) nums[i].toLong()
                                  .also{
                                        nums[i] = 0
                                        nums[minOf(nums.lastIndex, i+1)] = 0
                                        nums[maxOf(0, i-1)] = 0
                                  }
                else 0L
            }
}

