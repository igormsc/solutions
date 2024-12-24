class Solution2436 {
    fun minimumSplits(nums: IntArray): Int {
        var g = 0
        return nums.count { n ->
                                g = gcd(g, n)
                                (g == 1 ).also { if (it) g = n} } + 1
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

}