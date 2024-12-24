class Solution2282 {
    fun seePeople(heights: Array<IntArray>): Array<IntArray> {
        val (m, n) = heights.size to heights[0].size
        val res = Array(m) { IntArray(0) }
        (0..<m).forEach { res[it] = f(heights[it]) }
        for (j in 0..<n) {
            val nums = IntArray(m)
            (0..<m).forEach { nums[it] = heights[it][j] }
            val add = f(nums)
            (0..<m).forEach { res[it][j] += add[it] }
        }
        return res
    }

    private fun f(nums: IntArray): IntArray {
        val n = nums.size
        val res = IntArray(n)
        val stk = mutableListOf<Int>()
        for (i in n - 1 downTo 0) {
            while (stk.isNotEmpty() && stk.last() < nums[i]) {
                stk.removeLast()
                res[i]++
            }
            if (stk.isNotEmpty()) res[i]++
            while (stk.isNotEmpty() && stk.last() == nums[i]) stk.removeLast()
            stk.add(nums[i])
        }
        return res
    }

}