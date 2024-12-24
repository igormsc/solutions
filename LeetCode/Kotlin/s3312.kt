class Solution3312 {
    fun gcdValues(nums: IntArray, queries: LongArray): IntArray {
        val mx = nums.max()
        val cnt = nums.fold(mutableMapOf<Int, Int>()) { r, n -> r[n] = (r[n] ?: 0) + 1; r }

        val gcd = LongArray(mx + 1)
        for (a in mx downTo 1) {
            var mul = 0L
            for (b in a..mx step a) mul += (cnt[b]?:0).toLong()
            gcd[a] = mul * (mul - 1) / 2
            for (b in a*2..mx step a) gcd[a] -= gcd[b]
        }
        (1..mx).forEach { gcd[it] += gcd[it - 1] }

        fun upperBound(target: Long): Int {
            var (l, r) = 0 to gcd.size
            while (l < r) {
                val m = l + (r - l) / 2
                if (gcd[m] <= target) l = m + 1
                else r = m
            }
            return l
        }

        return queries.indices.fold(IntArray(queries.size)) { r, i -> r[i] = upperBound(queries[i]); r }
    }

}


