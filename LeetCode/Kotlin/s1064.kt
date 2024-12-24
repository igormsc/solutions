class Solution1064 {
    fun fixedPoint(arr: IntArray): Int {
        var (l, r) = 0 to arr.lastIndex
        while (l < r) {
            val m = (l + r)/2
            if (arr[m] >= m) r = m
            else l = m + 1
        }
        return if (arr[l] == l) l else -1
    }

}