class Solution1136 {
    fun minimumSemesters(n: Int, relations: Array<IntArray>): Int {
        var n = n
        val g= Array(n) {mutableListOf<Int>()}

        val indg = IntArray(n)
        for (r in relations) {
            val prev = r[0] - 1
            val nxt = r[1] - 1
            g[prev].add(nxt)
            indg[nxt]++
        }
        val q = mutableListOf<Int>()
        for (i in 0..<n)
            if (indg[i] == 0) q.add(i)

        var res = 0
        while (q.isNotEmpty()) {
            res++
            for (k in q.size downTo 1) {
                val i = q.removeFirst()
                n--
                for (j in g[i])
                    if (--indg[j] == 0) q.add(j)
            }
        }
        return if (n == 0) res else -1
    }

}