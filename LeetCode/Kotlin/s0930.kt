class Solution930 {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        fun f(g: Int): Int = if (g<0) 0 else {
            var i = 0
            var g = g
            nums.foldIndexed(0) { j, r, n ->
               g -= n
               while ( g < 0) g +=nums[i++]
               r + j - i + 1
            }
        }
        return f(goal) - f(goal-1)
    }

}

