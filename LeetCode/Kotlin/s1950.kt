class Solution1950 {
    fun findMaximums(nums: IntArray): IntArray {
        val n = nums.size
        val (l, r) = IntArray(n) {-1} to IntArray(n) {n}
        val stk = mutableListOf<Int>()
        for (i in 0..<n) {
            while (stk.isNotEmpty() && nums[stk.last()] >= nums[i]) stk.removeLast()
            if (stk.isNotEmpty()) l[i] = stk.last()
            stk.add(i)
        }
        stk.clear()
        for (i in n - 1 downTo 0) {
            while (stk.isNotEmpty() && nums[stk.last()] >= nums[i]) stk.removeLast()
            if (stk.isNotEmpty()) r[i] = stk.last()
            stk.add(i)
        }
        val res = IntArray(n)
        for (i in 0..<n) {
            val m = r[i] - l[i] - 1
            res[m - 1] = maxOf(res[m - 1], nums[i])
        }
        for (i in n - 2 downTo 0)
            res[i] = maxOf(res[i], res[i + 1])

        return res
    }

}