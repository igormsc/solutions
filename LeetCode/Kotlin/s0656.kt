class Solution656 {
    fun cheapestJump(coins: IntArray, maxJump: Int): List<Int> {
        val n = coins.size
        val res = mutableListOf<Int>()
        if (coins[n - 1] == -1) return res

        val f = IntArray(n) {Int.MAX_VALUE/2}
        f[n - 1] = coins[n - 1]

        for (i in n - 2 downTo 0)
            if (coins[i] != -1)
                for (j in i + 1..<minOf(n, (i + maxJump + 1)))
                    if (f[i] > f[j] + coins[i]) f[i] = f[j] + coins[i]

        if (f[0] == Int.MAX_VALUE/2) return res
        var i = 0
        var s = f[0]
        while (i < n) {
            if (f[i] == s) {
                s -= coins[i]
                res.add(i + 1)
            }
            i++
        }
        return res
    }

}