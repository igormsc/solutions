class Solution3201 {
    fun maximumLength(nums: IntArray): Int =
        nums.fold(IntArray(4)) { r, n ->
            r[n%2]++
            r[n%2+2] = maxOf(r[n%2+2], r[3-n%2] + 1)
            r }.max()
}
