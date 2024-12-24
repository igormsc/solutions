class Solution1121 {
    fun canDivideIntoSubsequences(nums: IntArray, k: Int): Boolean {
        var a = 0
        var cnt = 0
        for (b in nums) {
            cnt = if (a == b) cnt + 1 else 1
            if (cnt * k > nums.size) return false
            a = b
        }
        return true
    }

}