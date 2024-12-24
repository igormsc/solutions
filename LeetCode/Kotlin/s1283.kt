class Solution1283 {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        var (l,r) = 1 to Int.MAX_VALUE/4
        while (l<r) {
            val m = (l+r)/2
            if (nums.sumOf{ (it+m-1)/m } > threshold) l = m+1 else r = m
        }
        return l
    }
}