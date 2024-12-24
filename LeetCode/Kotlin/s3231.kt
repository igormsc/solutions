class Solution3231 {
    fun minOperations(nums: IntArray): Int {
        val g = mutableListOf<Int>()
        for (n in nums) {
            var (l, r) = 0 to g.size
            while (l < r) {
                val m = (l + r) / 2
                if (g[m] < n) r = m
                else l = m + 1
            }
            if (l == g.size) g.add(n)
            else g[l] = n
        }
        return g.size
    }

}