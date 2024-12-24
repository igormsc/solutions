class Solution350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val m1 = nums1.fold(mutableMapOf<Int, Int>()) { r, n -> r[n] = (r[n] ?: 0) + 1; r }
        return nums2.fold(mutableListOf<Int>()) { r, n ->
                        if (m1.contains(n)) {
                            m1[n] = (m1[n] ?: 0) - 1
                            if (m1[n]!! >= 0) r.add(n)
                        }
                        r }.toIntArray()
    }
}
