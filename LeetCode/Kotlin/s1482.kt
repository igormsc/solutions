class Solution1482 {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        val n = bloomDay.size
        var l = 1
        var r = 1_000_000_000
        if (m.toLong() * k.toLong() > n.toLong()) return -1
        while (l<r) {
            val mid = (l+r)/2
            var flow = 0
            var bq = 0
            (0..<n).forEach {
                if (bloomDay[it]>mid) flow = 0 else {
                    flow++
                    if (flow >= k) {
                        bq++
                        flow = 0
                    }
                }
            }
            if (bq < m) l = mid+1 else r = mid
        }
        return l
    }
}
