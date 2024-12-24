import java.util.*

class Solution2015 {
    fun averageHeightOfBuildings(buildings: Array<IntArray>): Array<IntArray> {
        val cnt = mutableMapOf<Int, Int>()
        val tm = TreeMap<Int, Int>()
        for ((s, e, h) in buildings) {
            cnt.merge(s, 1) { a: Int, b: Int -> a+b }
            cnt.merge(e, -1) { a: Int, b: Int -> a+b }
            tm.merge(s, h) { a: Int, b: Int -> a+b }
            tm.merge(e, -h) { a: Int, b: Int -> a+b }
        }
        var (s, m, last) = intArrayOf(0,0,-1)
        val res = mutableListOf<IntArray>()
        for ((k, v) in tm) {
            if (m > 0) {
                val avg = s / m
                if (res.isNotEmpty() && res.last()[2] == avg && res.last()[1] == last) res[res.size - 1][1] = k
                else res.add(intArrayOf(last, k, avg))
            }
            s += v
            m += cnt[k]!!
            last = k
        }
        return res.toTypedArray()
    }

}