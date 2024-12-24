class Solution275 {
    fun hIndex(citations: IntArray): Int {
        var (l, r) = 0 to citations.lastIndex
        val n = citations.size
        while (l<=r) {
            val m = (l+r)/2
            when {
                citations[m] == n - m -> return n-m
                citations[m] < (n-m) -> l = m+1
                else -> r = m-1
            }
        }
        return n-l
    }
}
