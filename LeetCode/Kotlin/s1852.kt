class Solution1852 {
    fun distinctNumbers(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val m = nums.max()
        val cnt = IntArray(m + 1)
        var v = (0..<k).count{ ++cnt[nums[it]] == 1 }

        val res = IntArray(n - k + 1).also {it[0]=v}
        for (i in k..<n) {
            if (++cnt[nums[i]] == 1) v++
            if (--cnt[nums[i - k]] == 0) v--
            res[i - k + 1] = v
        }
        return res
    }
}