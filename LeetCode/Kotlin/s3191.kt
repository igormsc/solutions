class Solution3191 {
    fun minOperations(nums: IntArray): Int =
        (0..<nums.lastIndex-1).sumOf { i ->
                nums[i].xor(1)
                    .also{
                            nums[i+1] = nums[i+1].xor(it)
                            nums[i+2] = nums[i+2].xor(it)
                    }
        }
            .let { if (nums.last() != 0 && nums[nums.lastIndex-1] != 0) it else -1 }

}
