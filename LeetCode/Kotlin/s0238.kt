class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size).also { it[0] = 1 }
        (0..<nums.lastIndex).forEach{ i -> res[i+1] = res[i]*nums[i]}
        (nums.lastIndex downTo 0).fold(1) { r, i -> res[i] *=r; r*nums[i]  }
        return res
    }
}

