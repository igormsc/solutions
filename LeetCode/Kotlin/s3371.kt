class Solution3371 {
    fun getLargestOutlier(nums: IntArray): Int {
        val cnt = nums.fold(mutableMapOf<Int, Int>()) { r, n -> r[2*n] = (r[2*n] ?: 0) + 1;r }
        val sum = nums.sum()
        return nums.fold(Int.MIN_VALUE) { r, n ->
            val t = sum - n
            if ((cnt[t]?:0) >= 2 || (cnt[t]?:0) == 1 && (t != n * 2)) maxOf(r, n) else r
        }
    }
}
