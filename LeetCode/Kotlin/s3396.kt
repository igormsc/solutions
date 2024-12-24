import kotlin.math.ceil

class Solution3396 {
    fun minimumOperations(nums: IntArray): Int {
        val m = mutableMapOf<Int,Int>()
        nums.indices.reversed().forEach { i ->
            val n = nums[i]
            m[n] = (m[n]?:0) + 1
            if (m[n]!! > 1) return ceil((i + 1).toDouble() / 3).toInt()
        }
        return 0
    }
}
