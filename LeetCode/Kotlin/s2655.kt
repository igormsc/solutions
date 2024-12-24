class Solution2655 {
    fun findMaximalUncoveredRanges(n: Int, ranges: Array<IntArray>): Array<IntArray> {
        ranges.sortBy { it[0] }
        val res = mutableListOf<IntArray>()
        val i = ranges.fold(-1) { x, (l,r) ->
                        if (x + 1 < l) res.add(intArrayOf(x + 1, l - 1))
                        maxOf(x, r) }
        if (i + 1 < n) res.add(intArrayOf(i + 1, n - 1))
        return res.toTypedArray()
    }

}