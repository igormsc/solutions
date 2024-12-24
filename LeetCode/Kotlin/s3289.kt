class Solution3289 {
    fun getSneakyNumbers(nums: IntArray): IntArray =
        nums.groupBy { it }.filter{it.value.size == 2}.map{it.key}.toIntArray()
}
