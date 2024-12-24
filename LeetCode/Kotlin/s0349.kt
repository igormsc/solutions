class Solution349 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray =
        nums1.intersect(nums2.toSet()).toIntArray()
}