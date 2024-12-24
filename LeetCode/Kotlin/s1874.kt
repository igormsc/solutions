class Solution1874 {
    fun minProductSum(nums1: IntArray, nums2: IntArray): Int {
        nums1.sort()
        nums2.sort()
        val n = nums1.lastIndex
        return nums1.indices.sumOf { nums1[it] * nums2[n - it] }
    }

}