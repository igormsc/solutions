import kotlin.math.absoluteValue

class Solution442 {
    fun findDuplicates(nums: IntArray): List<Int> =
        nums.fold(mutableListOf()) { r, n ->
            val n = n.absoluteValue-1
            nums[n] = -nums[n].also { if (it > 0) r.add(n+1) }
            r
        }

}
