class Solution1885 {
    fun countPairs(nums1: IntArray, nums2: IntArray): Long {
        val n = nums1.size
        val d = IntArray(n) { nums1[it] - nums2[it] }
        d.sort()
        return (0..<n).sumOf { i ->
            var (l, r) = i + 1 to n
            while (l < r) {
                val mid = (l + r) / 2
                if (d[mid] > -d[i]) r = mid
                else l = mid + 1
            }
            (n - l).toLong()
        }
    }

}