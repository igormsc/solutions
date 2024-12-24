class Solution3132 {
    fun minimumAddedInteger(nums1: IntArray, nums2: IntArray): Int {
        nums1.sort()
        nums2.sort()
        (2 downTo  1).forEach { i ->
            var s = i
            var j = i+1
            while (s<3 && j-s < nums2.size) if (nums2[j-s] - nums1[j++] != nums2[0] - nums1[i]) s++
            if (s<3) return nums2[0] - nums1[i]
        }
        return nums2[0] - nums1[0]
    }
}

fun main() {
    val nums1 = intArrayOf(4,7,5)
    val nums2 = intArrayOf(5)
    val sl = Solution3132()
    println(sl.minimumAddedInteger(nums1, nums2))

    println("Expected -2")

}


