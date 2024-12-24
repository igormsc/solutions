import kotlin.math.ceil

class Solution3366 {
    fun minArraySum(nums: IntArray, k: Int, op1: Int, op2: Int): Int {
        val dp = Array(nums.size) { Array(op1 + 1) { arrayOfNulls<Int>(op2 + 1) } }

        fun f(i: Int, k: Int, op1: Int, op2: Int): Int {
            if (i == nums.size) return 0
            if (dp[i][op1][op2] != null) return dp[i][op1][op2]!!

            var res = f(i + 1, k, op1, op2) + nums[i]
            if (nums[i] >= k && op2 > 0) {
                res = minOf(res, f( i + 1, k, op1, op2 - 1) + nums[i] - k)
                var v = ceil(nums[i] / 2.0).toInt()
                if (v < k) v = ceil((nums[i] - k) / 2.0).toInt()
                else v -= k
                if (op1 > 0) res = minOf(res, f( i + 1, k, op1 - 1, op2 - 1) + v)
            }
            if (op1 > 0) {
                val v = ceil(nums[i] / 2.0).toInt()
                res = minOf(res, f( i + 1, k, op1 - 1, op2) + v)
            }
            return res.also { dp[i][op1][op2] = it }
        }
        return f(0, k, op1, op2)
    }

}