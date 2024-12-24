class Solution760 {
    fun anagramMappings(nums1: IntArray, nums2: IntArray): IntArray {
        val m = mutableMapOf<Int, MutableSet<Int>>()
        for (i in nums2.indices) {
            m.computeIfAbsent(nums2[i]) { mutableSetOf() }.add(i) }
        val res = IntArray(nums1.size)
        for (i in nums1.indices) {
            val idx = m[nums1[i]]!!.iterator().next()
            res[i] = idx
            m[nums1[i]]!!.remove(idx)
        }
        return res
    }

}