import java.util.*
import kotlin.Comparator

class Solution2863 {
    fun maxSubarrayLength(nums: IntArray): Int {
        val tm = TreeMap<Int, MutableList<Int>>(Comparator.reverseOrder())
        for (i in nums.indices)
            tm.computeIfAbsent(nums[i]) { mutableListOf() }.add(i)
        var res = 0
        var k = Int.MAX_VALUE/2
        for (idx in tm.values) {
            res = maxOf(res, idx[idx.size - 1] - k + 1)
            k = minOf(k, idx[0])
        }
        return res
    }

}