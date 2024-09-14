class Solution3264 {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        fun ind(): Int {
            var r = 0
            var min = nums[0]
            for (i in 1..<nums.size)
                if (min > nums[i]) {
                    min = nums[i]
                    r = i
                }
            return r
        }

        for (i in 0..<k) nums[ind()] *= multiplier
        return nums
    }
}