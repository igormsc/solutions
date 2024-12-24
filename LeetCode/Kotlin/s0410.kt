class Solution410 {
    fun splitArray(nums: IntArray, k: Int): Int {
        var (l,r) = nums.max() to nums.sum()
        while (l<r) {
            val m = (l+r)/2
            var (s, cnt) = Int.MAX_VALUE/2 to 0
            nums.forEach { n ->
                s += n
                if (s>m) cnt++.also{s=n}
            }
            if (cnt<=k) r = m else l = m+1
        }
        return l
    }
}
