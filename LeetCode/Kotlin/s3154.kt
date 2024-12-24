class Solution3154 {
    fun waysToReachStair(k: Int): Int {
        fun comb(n: Int, k: Int): Int =
            if (k < 0 || k > n) 0
            else (0..<k).fold(1L) { r, i -> r * (n - i) / (i + 1) }.toInt()

        return (0..30).sumOf { comb(it + 1, (1.shl(it) - k)) }
    }

    private fun comb(n: Int, k: Int): Int {
        if (k < 0 || k > n) return 0
        var res = 1L
        for (i in 0..<k) res = res * (n - i) / (i + 1)
        return res.toInt()
    }

}