import kotlin.math.absoluteValue

class Solution3171 {
    fun minimumDifference(nums: IntArray, k: Int): Int =
        nums.foldIndexed(Int.MAX_VALUE) { i, r, n ->
            var mn = minOf(r, (k-n).absoluteValue)
            var j = i-1
            while (j>=0 && (nums[j] or n != nums[j])) {
                nums[j] = nums[j] or n
                mn = minOf(mn, (k-nums[j--]).absoluteValue)
            }
            mn }
}
