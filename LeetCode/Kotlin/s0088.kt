class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m-1
        var j = n-1
        var t = n+m-1

        while (j>=0) {
            if (i>=0 && nums1[i]>nums2[j]) nums1[t] = nums1[i--]
            else nums1[t] = nums2[j--]
            t--
        }
    }
}
