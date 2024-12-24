class Solution2422 {
    fun minimumOperations(nums: IntArray): Int {
        var (l,r) = 0 to nums.lastIndex
        var a = nums[l].toLong()
        var b = nums[r].toLong()
        var res = 0
        while (l < r) {
            if (a < b) {
                a += nums[++l].toLong()
                res++
            } else if (b < a) {
                b += nums[--r].toLong()
                res++
            } else {
                a = nums[++l].toLong()
                b = nums[--r].toLong()
            }
        }
        return res
    }

}