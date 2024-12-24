class Solution1231 {
    fun maximizeSweetness(sweetness: IntArray, k: Int): Int {
        fun chk(x: Int, k: Int): Boolean {
            var (s, cnt) = 0 to 0
            for (v in sweetness) {
                s += v
                if (s >= x) s = 0 .also {cnt++}
            }
            return cnt > k
        }

        var (l, r) = 0 to sweetness.sum()
        while (l < r) {
            val mid = (l + r + 1)/2
            if (chk(mid, k)) l = mid
            else r = mid - 1
        }
        return l
    }

}