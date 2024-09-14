class Solution2419 {
    fun longestSubarray(nums: IntArray): Int {
        var (res, cnt, mx) = intArrayOf(0,0,0)
        nums.forEach { n ->
            if (mx<n) {
                mx = n
                res = 0
                cnt = 0
            }
            if (n==mx) cnt++ else cnt = 0
            res = maxOf(res,cnt)
        }
        return res
    }
}
