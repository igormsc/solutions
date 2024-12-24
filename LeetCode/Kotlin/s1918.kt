class Solution1918 {
    fun kthSmallestSubarraySum(nums: IntArray, k: Int): Int {
        fun f(s: Int): Int {
            var (t,j,cnt) = intArrayOf(0,0,0)
            nums.indices.forEach { i->
                t += nums[i]
                while (t > s) t -= nums[j++]
                cnt += i - j + 1
            }
            return cnt
        }

        var (l,r) = nums.min() to nums.sum()
        while (l < r) {
            val mid = (l + r) shr 1
            if (f(mid) >= k) r = mid
            else l = mid + 1
        }
        return l
    }

}