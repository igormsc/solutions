class Solution3162 {
    fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Int =
        nums1.sumOf { n1 -> nums2.count { n2 -> n1 % (n2 * k) == 0 } }
}