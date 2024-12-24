class Solution962 {
    fun maxWidthRamp(nums: IntArray): Int {
        val v = mutableListOf(0)
        var res = 0
        var i = 1
        while (nums[v.last()] > nums.last()) {
            if (nums[v.last()]>nums[i]) v.add(i)
            i++
        }
        i = nums.lastIndex
        while (i>res) {
            while (v.isNotEmpty() && nums[v.last()] <= nums[i])
                res = maxOf(res, i-v.removeLast())
            i--
        }
        return res
    }
}
