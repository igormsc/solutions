class Solution3281 {
    fun maxPossibleScore(start: IntArray, d: Int): Int {
        start.sort()
        var (l,r) = 0L to start[1].toLong() + d - start[0]
        while (l<r) {
            val m = (l+r+1L)/2L
            var p = start[0].toLong()
            var i = 1
            while (i<start.size) {
                p = maxOf(start[i].toLong(), p + m)
                if (p>start[i]+d) break
                i++
            }
            if (i==start.size) l = m else r = m-1
        }
        return l.toInt()
    }
}