class Solution3394 {
    fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
        fun chk(s: Int, a: Int, b: Int): Boolean {
            rectangles.sortBy { it[s] }
            var cnt = 0
            var mx = rectangles[0][b]
            for (i in rectangles)
                mx = if (i[a] < mx) maxOf(i[b], mx) else i[b].also{cnt++}
            return cnt > 1
        }
        return chk(0, 0, 2) || chk( 1, 1, 3)
    }
}