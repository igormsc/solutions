class Solution2300 {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        potions.sort()
        val (n, m) = spells.size to potions.size
        val res = IntArray(n)
        res.indices.forEach{ i ->
            var (l, r) = 0 to m
            while (l < r) {
                val x = (l + r) / 2
                if (spells[i].toLong() * potions[x] >= success) r = x else l = x + 1
            }
            res[i] = m - l
        }
        return res
    }
}
