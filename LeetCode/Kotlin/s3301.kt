
class Solution3301 {
    fun maximumTotalSum(maximumHeight: IntArray): Long {
        var res = 0L
        var pre = Int.MAX_VALUE
        maximumHeight.sort()
        maximumHeight.reversed().forEach { h ->
            val v = minOf(pre - 1, h)
            pre = v
            if (v == 0) return -1
            res += v.toLong()
        }
        return res
    }
}
