class Solution1063 {
    fun validSubarrays(nums: IntArray): Int {
        val n = nums.size
        val stk = mutableListOf<Int>()
        var res = 0
        for (i in n - 1 downTo 0) {
            while (stk.isNotEmpty() && nums[stk.last()] >= nums[i]) stk.removeLast()
            res = res - i + if (stk.isEmpty()) n else stk.last()
            stk.add(i)
        }
        return res
    }

}