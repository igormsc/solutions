class Solution3221 {
    fun maxScore(nums: IntArray): Long {
        val stk = mutableListOf<Int>()
        nums.indices.forEach { i ->
            while (stk.isNotEmpty() && nums[stk.last()] <= nums[i]) stk.removeLast()
            stk.add(i)
        }
        var res = 0L
        var i = 0L
        while (stk.isNotEmpty()) {
            val j = stk.removeFirst()
            res += (j - i) * nums[j]
            i = j.toLong()
        }
        return res
    }
}