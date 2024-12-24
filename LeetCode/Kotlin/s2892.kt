class Solution2892 {
    fun minArrayLength(nums: IntArray, k: Int): Int {
        var res = 1
        var y = nums[0].toLong()
        for (i in 1..nums.lastIndex) {
            val x = nums[i]
            if (x == 0) return 1
            if (x * y <= k) y *= x.toLong()
            else {
                y = x.toLong()
                res++
            }
        }
        return res
    }

}