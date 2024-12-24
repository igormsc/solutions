class Solution2393 {
    fun countSubarrays(nums: IntArray): Long {
        var res = 0L
        var pre = 0
        var cnt = 0
        for (x in nums) {
            if (pre < x) cnt++
            else cnt = 1
            pre = x
            res += cnt.toLong()
        }
        return res
    }

}