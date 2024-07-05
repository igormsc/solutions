class Solution {
    fun runningSum(nums: IntArray): IntArray = nums.runningReduce(Int::plus).toIntArray()

}