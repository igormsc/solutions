class Solution034 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var (i, j) = 0 to nums.lastIndex
        val res = intArrayOf(-1, -1)
        if (nums.isEmpty()) return res
        while (i < j) {
            val m = (i+j)/2
            if (nums[m] < target) i = m+1 else j = m
        }
        if (nums[i] != target) return res
        res[0] = i
        j = nums.lastIndex
        while (i < j) {
            val m = (i+j)/2+1
            if (nums[m]>target) j = m-1 else i = m
        }
        res[1] = j
        return res
    }
}