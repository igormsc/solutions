class Solution2832 {
    fun maximumLengthOfRanges(nums: IntArray): IntArray {
        val n = nums.size
        val l = IntArray(n) {-1}
        val r = IntArray(n) {n}
        val stk = mutableListOf<Int>()
        for (i in 0..<n) {
            while (stk.isNotEmpty() && nums[stk.last()] <= nums[i]) stk.removeLast()
            if (stk.isNotEmpty()) l[i] = stk.last()
            stk.add(i)
        }
        stk.clear()
        for (i in n - 1 downTo 0) {
            while (stk.isNotEmpty() && nums[stk.last()] <= nums[i]) stk.removeLast()
            if (stk.isNotEmpty()) r[i] = stk.last()
            stk.add(i)
        }
        val res = IntArray(n)
        for (i in 0..<n)
            res[i] = r[i] - l[i] - 1
        return res
    }

}