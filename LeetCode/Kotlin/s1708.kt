class Solution1708 {
    fun largestSubarray(nums: IntArray, k: Int): IntArray {
        var j = 0
        for (i in 1..nums.size - k)
            if (nums[j] < nums[i]) j = i
        return nums.sliceArray(j..<j + k)
    }

}