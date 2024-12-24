import kotlin.math.absoluteValue

class Solution3354 {
    fun countValidSelections(nums: IntArray): Int {
        val ps = nums.runningReduce(Int::plus)
        var res = 0
        nums.indices.forEach { i ->
            if (nums[i] == 0)
                if (ps.last() == 2 * ps[i]) res += 2
                else if ((ps.last() - 2*ps[i]).absoluteValue == 1) res++
        }
        return res
    }
}
