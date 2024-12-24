class Solution1983 {
    fun widestPairOfIndices(nums1: IntArray, nums2: IntArray): Int {
        var s = 0
        val m = mutableMapOf(0 to -1)
        return nums1.indices.fold(0) { r, i ->
            s += nums1[i] - nums2[i]
            if (m.containsKey(s)) maxOf(r, i - m[s]!!) else r.also{m[s] = i}
        }
    }

}