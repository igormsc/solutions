class Solution2444 {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long =
        nums.foldIndexed(0L to IntArray(3) { -1 }) { i, (r, p), n ->
            if (n < minK || n > maxK) p[0] = i
            if (n == minK) p[1] = i
            if (n == maxK) p[2] = i
            r + (minOf(p[1], p[2]) - p[0]).let{ if (it > 0) it.toLong() else 0L} to p
        }.first

}
