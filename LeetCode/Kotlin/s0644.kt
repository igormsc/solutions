class Solution644 {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val eps = 1e-5
        var l = 1e10
        var r = -1e10
        for (x in nums) {
            l = minOf(l, x.toDouble())
            r = maxOf(r, x.toDouble())
        }

        fun chk(v: Double): Boolean {
            var s = (0..<k).sumOf { i -> nums[i].toDouble() - v }
            if (s >= 0.0) return true
            var t = 0.0
            var mi = 0.0
            for (i in k..nums.lastIndex) {
                s += nums[i].toDouble() - v
                t += nums[i - k].toDouble() - v
                mi = minOf(mi, t)
                if (s >= mi) return true
            }
            return false
        }

        while (r - l >= eps) {
            val mid = (l + r) / 2
            if (chk(mid)) l = mid
            else r = mid
        }
        return l
    }

}