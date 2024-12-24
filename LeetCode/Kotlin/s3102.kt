import kotlin.math.absoluteValue

class Solution3102 {
    fun minimumDistance(points: Array<IntArray>): Int {
        fun mht(i: Int, j: Int): Int =
            (points[i][0] - points[j][0]).absoluteValue + (points[i][1] - points[j][1]).absoluteValue

        fun maxD(rm: Int): IntArray {
            val s = intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE)
            val d = intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE)
            val sI = intArrayOf(-1, -1)
            val dI = intArrayOf(-1, -1)
            points.forEachIndexed { i, p ->
                if (i != rm) {
                    val sum = p[0] + p[1]
                    val diff = p[0] - p[1]
                    if (sum > s[0]) {
                        sI[0] = i
                        s[0] = sum
                    }
                    if (sum < s[1]) {
                        sI[1] = i
                        s[1] = sum
                    }
                    if (diff > d[0]) {
                        dI[0] = i
                        d[0] = diff
                    }
                    if (diff < d[1]) {
                        dI[1] = i
                        d[1] = diff
                    }
                }
            }
            return if (maxOf((s[0] - s[1]), (d[0] - d[1])) == s[0] - s[1]) intArrayOf(sI[0], sI[1]) else intArrayOf(dI[0], dI[1])
        }

        val m = maxD(-1)
        val (m1, m2) = maxD(m[0]) to maxD(m[1])
        return minOf(mht(m1[0], m1[1]), mht(m2[0], m2[1]))
    }

}