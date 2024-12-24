class Solution1671 {
    fun minimumMountainRemovals(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        val (l, r) = mutableListOf<Int>() to mutableListOf<Int>()
        nums.indices.forEach { i ->
            l.binarySearch(nums[i]).let { if (it < 0) -(it + 1) else it }
                .also { if (it == l.size) l.add(nums[i]) else l[it] = nums[i] }
            dp[i] = l.size
        }
        return (nums.lastIndex downTo 0).fold(Int.MAX_VALUE) { res, i ->
            r.binarySearch(nums[i]).let { if (it < 0) -(it + 1) else it }
                .also { if (it == r.size) r.add(nums[i]) else r[it] = nums[i] }
            if (dp[i] > 1 && r.size > 1) minOf(nums.size - dp[i] - r.size + 1, res) else res
        }
    }
}
