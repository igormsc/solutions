class Solution2941 {
    fun maxGcdSum(nums: IntArray, k: Int): Long {
            val n = nums.size
            val s = LongArray(n + 1)
            (1..n).forEach { s[it] = s[it - 1] + nums[it - 1]}
            var f =  mutableListOf<IntArray>()
            var res = 0L

            for (i in 0..<n) {
                val g = mutableListOf<IntArray>()
                for (e in f) {
                    val (j,x) = e
                    val y = gcd(x, nums[i])
                    if (g.isEmpty() || g[g.size - 1][1] != y) g.add(intArrayOf(j, y))
                }
                f = g
                f.add(intArrayOf(i, nums[i]))
                for (e in f) {
                    val (j,x) = e
                    if (i - j + 1 >= k) res = maxOf(res, (s[i + 1] - s[j]) * x)
                }
            }
            return res
        }

        private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

}