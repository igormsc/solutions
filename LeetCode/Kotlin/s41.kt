import kotlin.math.absoluteValue

class Solution41 {
    fun firstMissingPositive(nums: IntArray): Int {
        val maxIndex = nums.size + 1;
        nums.indices.forEach { if (nums[it] <= 0) nums[it] = maxIndex }
        nums.forEach{ it.absoluteValue.also { if (it < maxIndex && nums[it - 1] > 0) nums[it - 1] *= -1 } }
        return nums.withIndex().find { it.value > 0 }?.index?.inc()?:maxIndex
    }

}