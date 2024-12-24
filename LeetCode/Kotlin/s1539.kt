class Solution1539 {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var (l,r) = 0 to arr.size
        while (l<r) {
            val m = (l+r)/2
            if (arr[m]-1-m<k) l = m+1 else r=m
        }
        return l+k
    }
}
