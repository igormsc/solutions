class Solution004 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val (m,n) = nums1.size to nums2.size

        fun fs(i: Int, j: Int, k: Int):Double =
            when {
                i >= m -> nums2[j + k - 1]
                j >= n -> nums1[i + k - 1]
                k == 1 -> minOf(nums1[i], nums2[j])
                else -> {
                    val p = k / 2
                    val x = if (i + p - 1 < m) nums1[i + p - 1] else Int.MAX_VALUE/2
                    val y = if (j + p - 1 < n) nums2[j + p - 1] else Int.MAX_VALUE/2
                    if (x < y) fs(i + p, j, k - p) else fs(i, j + p, k - p)
                }
        }.toDouble()

        return (fs(0, 0, (m + n + 1) / 2) + fs(0, 0, (m + n + 2) / 2))/2.0
    }
}
