class Solution3160 {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val balls = mutableMapOf<Int,Int>()
        val cnt = mutableMapOf<Int,Int>()
        val res = mutableListOf<Int>()
        queries.forEach { q ->
            val (x,y) = q
            val c = balls[x]?:0
            if (c != 0) {
                cnt[c] = (cnt[c]?:0) - 1
                if (cnt[c]!! == 0) cnt.remove(c)
            }
            balls[x] = y
            cnt[y] = (cnt[y]?:0) + 1
            res.add(cnt.size)
        }
        return res.toIntArray()
    }
}
