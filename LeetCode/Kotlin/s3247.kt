class Solution3247 {
    fun subsequenceCount(nums: IntArray): Int {
        val mod = 1_000_000_007
        var f = IntArray(2)
        for (n in nums) {
            val g = IntArray(2)
            if (n % 2 == 1) {
                g[0] = (f[0] + f[1]) % mod
                g[1] = (f[0] + f[1] + 1) % mod
            } else {
                g[0] = (f[0] + f[0] + 1) % mod
                g[1] = (f[1] + f[1]) % mod
            }
            f = g
        }
        return f[1]
    }

}