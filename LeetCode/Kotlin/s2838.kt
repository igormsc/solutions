class Solution2838 {
    fun maximumCoins(heroes: IntArray, monsters: IntArray, coins: IntArray): LongArray {
        val m = monsters.size
        val idx = IntArray(m) {it}.sortedBy { monsters[it] }.toIntArray()
        val s = LongArray(m + 1)
        for (i in 0..<m)
            s[i + 1] = s[i] + coins[idx[i]]

        fun search(idx: IntArray, x: Int): Int {
            var l = 0
            var r = idx.size
            while (l < r) {
                val mid = (l + r) shr 1
                if (monsters[idx[mid]] > x) r = mid
                else l = mid + 1
            }
            return l
        }

        val n = heroes.size
        val res = LongArray(n)
        for (k in 0..<n) {
            val i = search(idx, heroes[k])
            res[k] = s[i]
        }
        return res
    }

}
