import kotlin.math.max
import kotlin.math.min

class Solution3086 {
    fun minimumMoves(nums: IntArray, k: Int, maxChanges: Int): Long {
        val arr = mutableListOf(0L)
        nums.indices.forEach { if (nums[it] > 0) arr.add(arr.last() + it) }
        val n = arr.lastIndex
        val m = maxOf(0, k - maxChanges)
        return (m..minOf(n, m + 3, k)).fold(Long.MAX_VALUE) { res, l ->
            (0..n - l).fold(res) { res, i ->
                minOf(res, (arr[i + l] - arr[i + l - l / 2] - arr[i + l / 2] + arr[i] + (k - l) * 2))
            }
        }
    }

}
