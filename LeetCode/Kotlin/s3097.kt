class Solution3097 {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        val cnt = IntArray(30)
        var cur = 0
        var res = Int.MAX_VALUE
        var j = 0
        nums.forEachIndexed{ i, n ->
            (0..29).forEach { b ->
                if ( (1 shl b).and(n) != 0) {
                    cnt[b]++
                    if (cnt[b] ==1) cur += 1 shl b
                }
                while (cur >= k && j <= i) {
                    res = minOf(res, i-j+1)
                    (0..29).forEach { b ->
                        if ( (1 shl b).and(nums[j]) != 0) {
                            cnt[b]--
                            if (cnt[b] == 0 ) cur -= 1 shl b
                        }
                    }
                    j++
                }
            }
        }
        return if (res == Int.MAX_VALUE) -1 else res
    }
}
