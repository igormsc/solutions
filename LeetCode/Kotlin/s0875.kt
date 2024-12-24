class Solution875 {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var (l, r) = 1 to piles.max()
        while (l<r) {
            val m = (r+l)/2
            if (piles.sumOf { (it+m-1)/m}>h) l = m+1 else r = m
        }
        return l
    }
}
