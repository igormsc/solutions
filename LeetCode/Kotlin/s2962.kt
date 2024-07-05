class Solution2962 {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val max = nums.max()
        var v = 0
        var i = 0
        return nums.sumOf {
            if (it == max) v++
            while (v >= k) if (nums[i++] == max) v--
            i.toLong()
        }
    }

}