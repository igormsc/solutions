class Solution2762 {
    fun continuousSubarrays(nums: IntArray): Long {
        val (mn, mx) = mutableListOf<Int>() to mutableListOf<Int>()
        val n = nums.size
        var (l, res) = 0 to 0L
        (0..<n).forEach { r ->
            while (mx.isNotEmpty() && nums[mx.last()] < nums[r]) mx.removeLast()
            mx.add(r)
            while (mn.isNotEmpty() && nums[mn.last()] > nums[r]) mn.removeLast()
            mn.add(r)
            while (nums[mx.first()] - nums[mn.first()] > 2) {
                when {
                    mx.first()<mn.first() -> mx.removeFirst()
                    mx.first() > mn.first() -> mn.removeFirst()
                    else -> mn.removeFirst().also{ mx.removeFirst() }
                }
                l = maxOf(l, minOf(mx.first(), mn.first()))
            }
            res += (r-l+1).toLong()
        }
        return res
    }
}
