class Solution354 {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        envelopes.sortWith(compareBy({ it[0] }, { -it[1] }))
        val d = IntArray(envelopes.size + 1).also{it[1] = envelopes[0][1]}
        var j = 1
        (1..envelopes.lastIndex).forEach { i ->
            val e = envelopes[i][1]
            if (e > d[j]) d[++j] = e
            else {
                var (l, r) = 1 to j
                while (l < r) {
                    val m = (l + r) / 2
                    if (d[m] >= e) r = m else l = m + 1
                }
                d[if (d[l] >= e) l else 1] = e
            }
        }
        return j
    }
}
