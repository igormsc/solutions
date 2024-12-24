class Solution1060 {
    fun missingElement(nums: IntArray, k: Int): Int {
        val n = nums.lastIndex
        fun missing(i: Int): Int = nums[i] - nums[0] - i

        if (k > missing(n)) return nums.last() + k - missing(n)
        var (l, r) = 0 to n
        while (l < r) {
            val mid = (l + r)/2
            if (missing(mid) >= k) r = mid
            else l = mid + 1
        }
        return nums[l - 1] + k - missing(l - 1)
    }

}