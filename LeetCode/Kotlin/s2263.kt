import kotlin.math.absoluteValue

class Solution2263 {
    fun convertArray(nums: IntArray): Int {
        val a = clc(nums)
        nums.reverse()
        val b = clc(nums)
        return minOf(a,b)
    }

    private fun clc(nums: IntArray): Int {
        val n = nums.size
        val arr = Array(n + 1) { IntArray(1001) }
        for (i in 1..n) {
            var mn = Int.MAX_VALUE/2
            for (j in 0..1000) {
                mn = minOf(mn, arr[i - 1][j])
                arr[i][j] = mn + (j - nums[i - 1]).absoluteValue
            }
        }
        return arr[n].min()
    }

}