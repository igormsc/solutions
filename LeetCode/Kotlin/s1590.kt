class Solution1590 {
    fun minSubarray(nums: IntArray, p: Int): Int {
        val n = nums.size
        var (res, cur) = n to 0
        val need = nums.fold(0) { r, a -> (r+a)%p}
        val last = mutableMapOf(0 to -1)
        nums.indices.forEach { i ->
            cur = (cur+nums[i])%p
            last[cur] = i
            val want = (cur-need+p)%p
            if (last.contains(want)) res = minOf(i-last[want]!!, res)
        }
        return if (res<n) res else -1
    }
}
