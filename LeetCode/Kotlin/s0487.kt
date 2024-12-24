class Solution487 {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var i = 0
        var cnt = 0
        nums.forEach { x ->
            cnt += x.xor(1)
            if (cnt > 1) cnt -= nums[i++].xor(1)
        }
        return nums.size - i
    }

}