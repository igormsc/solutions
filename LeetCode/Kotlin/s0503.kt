class Solution503 {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val n = nums.size
        val stk = mutableListOf<Int>()
        return (0..<2*n).fold(IntArray(n) {-1}) { r, i ->
            while (stk.isNotEmpty() && nums[stk.last()] < nums[i%n]) r[stk.removeLast()] = nums[i%n]
            stk.add(i%n)
            r }
    }
}
