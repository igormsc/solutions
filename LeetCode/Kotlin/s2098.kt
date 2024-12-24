class Solution2098 {
    fun largestEvenSum(nums: IntArray, k: Int): Long {
        nums.sort()
        val n = nums.size
        val res = (0..<k).sumOf { nums[n - it - 1].toLong() }
        if (res % 2 == 0L) return res

        var (mx1, mx2) = Int.MIN_VALUE/4 to Int.MIN_VALUE/4
        for (i in 0..<n - k)
            if (nums[i] % 2 == 1) mx1 = nums[i]
            else mx2 = nums[i]

        var (mn1, mn2) = Int.MAX_VALUE/4 to Int.MAX_VALUE/4
        for (i in n - 1 downTo n - k)
            if (nums[i] % 2 == 1) mn2 = nums[i]
            else mn1 = nums[i]

        return  maxOf(res - mn1 + mx1, res - mn2 + mx2).let{ if (it < 0) -1 else it}
    }

}