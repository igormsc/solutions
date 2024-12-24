class Solution2702 {
    fun minOperations(nums: IntArray, x: Int, y: Int): Int {
        var (l, r) = 0 to nums.max()

        fun check(t: Int): Boolean {
            var cnt = 0L
            for (v in nums)
                if (v > t.toLong() * y) cnt += (v - t.toLong() * y + x - y - 1) / (x - y)
            return cnt <= t
        }

        while (l < r) {
            val mid = (l + r) ushr 1
            if (check(mid)) r = mid
            else l = mid + 1
        }
        return l
    }

}