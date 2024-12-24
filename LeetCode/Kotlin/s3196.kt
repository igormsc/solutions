
class Solution3196 {
    fun maximumTotalCost(nums: IntArray): Long =
        nums.fold(Long.MIN_VALUE/2 to 0L) { p, v ->
            val v = v.toLong()
            maxOf(p.first, p.second)+v to p.first-v
        }.let { maxOf(it.first,it.second) }

}
