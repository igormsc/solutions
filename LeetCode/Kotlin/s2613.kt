import kotlin.math.absoluteValue

class Solution2613 {
    fun beautifulPair(nums1: IntArray, nums2: IntArray): IntArray {
        val points = mutableListOf<IntArray>()
        val n = nums1.size
        val pl = mutableMapOf<Long, MutableList<Int>>()
        for (i in 0..<n) {
            val z = f(nums1[i], nums2[i])
            pl.computeIfAbsent(z) { mutableListOf() }.add(i)
        }
        for (i in 0..<n) {
            val z = f(nums1[i], nums2[i])
            if (pl[z]!!.size > 1) return intArrayOf(i, pl[z]!![1])
            points.add(intArrayOf(nums1[i], nums2[i], i))
        }
        points.sortWith { a: IntArray, b: IntArray -> a[0] - b[0] }

        fun dfs(l: Int, r: Int): IntArray {
            if (l >= r) return intArrayOf(1 shl 30, -1, -1)
            val m = (l + r) shr 1
            val x = points[m][0]
            var t1 = dfs(l, m)
            val t2 = dfs(m + 1, r)
            if (t1[0] > t2[0] || (t1[0] == t2[0] && (t1[1] > t2[1] || (t1[1] == t2[1] && t1[2] > t2[2]))))  t1 = t2
            val t = mutableListOf<IntArray>()
            for (i in l..r)
                if ((points[i][0] - x).absoluteValue <= t1[0]) t.add(points[i])
            t.sortWith { a: IntArray, b: IntArray -> a[1] - b[1] }
            for (i in t.indices)
                for (j in i + 1..<t.size) {
                    if (t[j][1] - t[i][1] > t1[0])  break
                    val pi = minOf(t[i][2], t[j][2])
                    val pj = maxOf(t[i][2], t[j][2])
                    val d = dist(t[i][0], t[i][1], t[j][0], t[j][1])
                    if (d < t1[0] || (d == t1[0] && (pi < t1[1] || (pi == t1[1] && pj < t1[2])))) t1 = intArrayOf(d, pi, pj)
                }
            return t1
        }

        return dfs(0, points.size - 1).let{ intArrayOf(it[1], it[2]) }
    }

    private fun f(x: Int, y: Int): Long = x.toLong() * 100000L + y.toLong()

    private fun dist(x1: Int, y1: Int, x2: Int, y2: Int): Int = (x1 - x2).absoluteValue + (y1 - y2).absoluteValue

}