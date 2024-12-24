class Solution280 {
    fun wiggleSort(nums: IntArray): Unit {
        for (i in 1..nums.lastIndex)
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1]))
                nums[i] = nums[i-1].also{ nums[i-1] = nums[i] }
    }
}