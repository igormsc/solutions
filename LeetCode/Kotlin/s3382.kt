class Solution3382 {
    fun maxRectangleArea(xCoord: IntArray, yCoord: IntArray): Long {
        val n = xCoord.size
        val points = Array(n) { IntArray(2) }
        val tmp = yCoord.copyOf(yCoord.size)
        tmp.sort()
        var p = 1
        for (i in 1..tmp.lastIndex)
            if (tmp[i] != tmp[p - 1]) tmp[p++] = tmp[i]
        val sy = tmp.copyOf(p)
        xCoord.indices.forEach { points[it] = intArrayOf(xCoord[it],  sy.binarySearch(yCoord[it])) }
        points.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

        val map = mutableMapOf<Long, Int>()
        val mapx = mutableMapOf<Long, Int>()
        var res = -1L
        val fenwick = IntArray(sy.size + 1)

        fun sumFenwick(i: Int): Int {
            var i = i + 1
            var sum = 0
            while (i > 0) {
                sum += fenwick[i]
                i -= i and -i
            }
            return sum
        }

        fun addFenwick(i: Int, v: Int) {
            var i = i + 1
            if (v == 0 || i < 1) return
            while (i < fenwick.size) {
                fenwick[i] += v
                i += i and -i
            }
        }

        for (i in points.indices) {
            addFenwick(points[i][1], 1)
            if (i - 1 >= 0 && points[i][0] == points[i - 1][0]) {
                val yc = points[i][1].toLong() shl 32 or points[i - 1][1].toLong()
                val prev = sumFenwick(points[i][1]) - sumFenwick(points[i - 1][1] - 1)
                if (map.containsKey(yc) && prev == map[yc]!! + 2)
                    res = maxOf(res, (points[i][0] - mapx[yc]!!).toLong() * (sy[points[i][1]] - sy[points[i - 1][1]]).toLong())
                map[yc] = prev
                mapx[yc] = points[i][0]
            }
        }

        return res
    }


}
