import kotlin.math.absoluteValue

class Solution2441 {
    fun findMaxK(nums: IntArray): Int =
        nums.fold(-1 to IntArray(2001)) { (r, a), n ->
            (if (a[1000-n] != 0) maxOf(r, n.absoluteValue) else r) to a.also { it[n+1000]++ } }.first
}
