class Solution646 {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortBy { it[1] }
        var res = 0
        var cur = Int.MIN_VALUE
        pairs.forEach { p ->
            if (p[0] > cur) {
                cur = p[1]
                res++
            }
        }
        return res
    }
}
