class Solution2505 {
    fun subsequenceSumOr(nums: IntArray): Long {
        var res = 0L
        val cnt = LongArray(64)

        for (n in nums)
            for (i in 0..30)
                if (n.shr(i).and(1) == 1) cnt[i]++
        for (i in 0..62) {
            if (cnt[i] > 0) res = res or (1L shl i)
            cnt[i + 1] += cnt[i] / 2
        }

        return res
    }

}