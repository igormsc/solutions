class Solution496 {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val s = mutableListOf<Int>()
        val mp = mutableMapOf<Int,Int>()
        nums2.forEach { n ->
            while (s.isNotEmpty() && s.last() < n)
                mp[s.removeLast()] = n
            s.add(n)
        }
        val res = mutableListOf<Int>()
        nums1.forEach { n ->
            if (mp.containsKey(n)) res.add(mp[n]!!) else res.add(-1)
        }
        return res.toIntArray()
    }
}