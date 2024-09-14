class Solution3255 {
    fun resultsArray(nums: IntArray, k: Int): IntArray =
        nums.indices.fold(1 to mutableListOf<Int>()) { (c, r), i ->
            (if (i > 0 && nums[i] - 1 == nums[i - 1]) c + 1 else 1)
                .let { x -> x to r.also { if (i >= k - 1) r.add(if (x >= k) nums[i] else -1) } }
        }.second.toIntArray()
}