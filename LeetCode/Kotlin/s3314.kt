class Solution3314 {
    fun minBitwiseArray(nums: List<Int>): IntArray =
        nums.foldIndexed(IntArray(nums.size)) { i, r, n ->
            if (n%2 == 0) r[i]--
            else r[i] = n - ((n + 1) and (-n - 1)) / 2
            r }
}
