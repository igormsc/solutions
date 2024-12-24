class Solution2524 {
    private val mod = 1_000_000_007

    fun maxFrequencyScore(nums: IntArray, k: Int): Int {
        val cnt = mutableMapOf<Int, Int>()
        for (i in 0..<k)
            cnt.merge(nums[i], 1) { a: Int, b: Int -> a+b }
        var cur = 0L
        for ((key, value) in cnt)
            cur = (cur + qpow(key.toLong(), value.toLong())) % mod
        var res = cur
        for (i in k..nums.lastIndex) {
            val a = nums[i - k]
            val b = nums[i]
            if (a != b) {
                cur += if ((cnt[b]?:0) > 0) (b - 1) * qpow(b.toLong(), cnt[b]!!.toLong()) % mod else b.toLong()
                cur -= if ((cnt[a]?:0) > 1) (a - 1) * qpow(a.toLong(), (cnt[a]!! - 1).toLong()) % mod else  a.toLong()
                cur = (cur + mod) % mod
                cnt[b] = (cnt[b]?:0) + 1
                cnt[a] = (cnt[a]?:0) - 1
                res = maxOf(res, cur)
            }
        }
        return res.toInt()
    }

    private fun qpow(a: Long, n: Long): Long {
        var a = a
        var n = n
        var res = 1L
        while (n > 0) {
            if ((n and 1L) == 1L) res = res * a % mod
            a = a * a % mod
            n = n shr 1
        }
        return res
    }

}