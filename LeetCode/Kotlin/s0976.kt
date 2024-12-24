class Solution976 {
    fun largestPerimeter(nums: IntArray): Int {
        nums.sort()
        for (i in nums.lastIndex downTo 2)
            if (nums[i] < nums[i-1]+nums[i-2]) return nums.slice(i-2..i).sum()
        return 0
    }
}
