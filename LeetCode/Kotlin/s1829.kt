class Solution1829 {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val res = IntArray(nums.size)
        var x = 1.shl(maximumBit) - 1
        nums.indices.forEach { i ->
            x = x.xor(nums[i])
            res[res.lastIndex-i] = x
        }
        return res
    }
}
