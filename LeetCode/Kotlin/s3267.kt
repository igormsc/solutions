class Solution3267 {
    private val pw = intArrayOf(1, 10, 100, 1000, 10000, 100000, 1000000, 10000000)

    fun countPairs(nums: IntArray): Int {
        val m = mutableMapOf<Int,Int>()
        var res = 0
        for (n in nums) {
            res += m[n]?:0
            val t = mutableSetOf<Int>()
            for (x in swp(n)) t.addAll(swp(x))
            for (y in t) m[y] = (m[y]?:0) + 1
        }
        return res
    }

    private fun swp(x: Int): Set<Int> {
        val s = mutableSetOf(x)
        for (i in 0..<7)
            for (j in i+1..<7) {
                val (a, b) = (x/pw[i])%10 to (x/pw[j])%10
                s.add(x - a * pw[i] + b * pw[i] - b * pw[j] + a * pw[j])
            }
        return s
    }
}