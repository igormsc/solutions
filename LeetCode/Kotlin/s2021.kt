import java.util.*

class Solution2021 {
    fun brightestPosition(lights: Array<IntArray>): Int {
        val tm = TreeMap<Int, Int>()
        for (x in lights) {
            val (l, r) = x[0] - x[1] to x[0] + x[1]
            tm.merge(l, 1) { a: Int, b: Int -> a+b }
            tm.merge(r + 1, -1) { a, b -> a+b }
        }
        var (res, s, mx) = intArrayOf(0,0,0)
        for ((key, v) in tm) {
            s += v
            if (mx < s) {
                mx = s
                res = key
            }
        }
        return res
    }

}