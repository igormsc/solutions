class Solution1011 {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var (l,r) = 0 to 0
        weights.forEach {w ->
            if (w>l) l = w
            r +=w
        }
        while (l<r) {
            val m = (l+r) /2
            var need = 1
            var cur = 0
            weights.forEach {w ->
                if (cur+w > m) {
                    need++
                    cur = 0
                }
                cur +=w
            }
            if (need > days) l = m+1 else r = m
        }
        return l
    }
}