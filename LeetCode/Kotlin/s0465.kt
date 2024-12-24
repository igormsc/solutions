class Solution465 {
    fun minTransfers(transactions: Array<IntArray>): Int {
        val g = IntArray(12)
        for (t in transactions) {
            g[t[0]] -= t[2]
            g[t[1]] += t[2]
        }

        val nums = mutableListOf<Int>()
        g.forEach { if (it != 0) nums.add(it) }

        val m = nums.size
        val f = IntArray(1.shl(m)) {1.shl(29)}
        f[0] = 0
        for (i in 1..<1.shl(m)) {
            var s = 0
            for (j in 0..<m)
                if ((i.shr(j).and(1)) == 1) s += nums[j]

            if (s == 0) {
                f[i] = Integer.bitCount(i) - 1
                var j = (i - 1).and(i)
                while (j > 0) {
                    f[i] = minOf(f[i], (f[j] + f[i.xor(j)]))
                    j = (j - 1).and(i)
                }
            }
        }
        return f[(1.shl(m)) - 1]
    }

}