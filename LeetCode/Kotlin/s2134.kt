class Solution2134 {
    fun minSwaps(nums: IntArray): Int {
        val n = nums.size
        var cnt = nums.count{ it == 1 }
        if (cnt == 0) return 0
        var z = (0..<cnt).count{ nums[it] == 0}
        return (cnt..<2*n).fold(z) { r, i ->
                    if (nums[i%n] == 0) z++
                    if (nums[(i-cnt)%n] == 0) z--
                    minOf(z, r) }
    }

}
