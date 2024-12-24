class Solution905 {
    fun sortArrayByParity(nums: IntArray): IntArray = nums.sortedWith{ a, _ -> a%2 }.toIntArray()
}

