class Solution1760 {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        var (l, r) = 1 to Int.MAX_VALUE/8
        while (l<r) {
            val m = (l+r)/2
            if (nums.sumOf {(it-1)/m} > maxOperations) l = m+1 else r = m
        }
        return l
    }
}
