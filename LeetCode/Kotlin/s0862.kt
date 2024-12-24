class Solution862 {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        val sums = nums.indices.fold(LongArray(nums.size+1)) { r, i -> r[i+1] = r[i] + nums[i].toLong(); r}
        var res = -1
        val q = mutableListOf<Int>()
        for (i in sums.indices) {
            while (q.isNotEmpty() && sums[q.last()] > sums[i]) q.removeLast()
            while (q.isNotEmpty() && sums[i]-sums[q[0]] >= k) {
                if (res > i-q[0] || res == -1) res = i-q[0]
                q.removeFirst()
            }
            q.add(i)
        }
        return res
    }
}
