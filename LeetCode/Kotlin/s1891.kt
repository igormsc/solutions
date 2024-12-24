class Solution1891 {
    fun maxLength(ribbons: IntArray, k: Int): Int {
        var (l, r) = 0 to ribbons.max()

        while (l < r) {
            val m = (l + r + 1) / 2
            if (ribbons.sumOf { it / m } >= k) l = m else r = m - 1 }

        return l
    }

}