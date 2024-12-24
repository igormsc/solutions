import kotlin.math.absoluteValue

class Solution3357 {
    fun minDifference(nums: IntArray): Int {
        val n = nums.size
        var mx = 0
        var mnA = Int.MAX_VALUE
        var maxb = 0
        for (i in 0..<n - 1) {
            val a = nums[i]
            val b = nums[i + 1]
            if (a > 0 && b > 0) mx = maxOf(mx, (a - b).absoluteValue)
            else if (a > 0 || b > 0) {
                mnA = minOf(mnA, maxOf(a, b))
                maxb = maxOf(maxb, maxOf(a, b))
            }
        }

        var res = 0
        val mn2r = (maxb - mnA + 2) / 3 * 2
        for (i in 0..<n) {
            if ((i > 0 && nums[i - 1] == -1) || nums[i] > 0) continue
            var j = i
            while (j < n && nums[j] == -1) j++
            var a = Int.MAX_VALUE
            var b = 0
            if (i > 0) {
                a = minOf(a, nums[i - 1])
                b = maxOf(b, nums[i - 1])
            }
            if (j < n) {
                a = minOf(a, nums[j])
                b = maxOf(b, nums[j])
            }
            res = if (j - i == 1) maxOf(res, minOf(maxb - a, b - mnA))
            else maxOf(res, minOf(maxb - a,b - mnA, mn2r))

        }
        return maxOf(mx, (res + 1) / 2)
    }
}