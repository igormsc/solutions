class Solution1908 {
    private val p = IntArray(8)
    private val mp = mutableMapOf<Int, Boolean>()

    init {
        p[0] = 1
        for (i in 1..7) {
            p[i] = p[i - 1] * 8
        }
    }

    fun nimGame(piles: IntArray): Boolean = dfs(piles)

    private fun dfs(piles: IntArray): Boolean {
        val st = piles.indices.sumOf { piles[it] * p[it] }
        if (mp.containsKey(st)) return mp[st]!!

        for (i in piles.indices)
            for (j in 1..piles[i]) {
                piles[i] -= j
                if (!dfs(piles)) {
                    piles[i] += j
                    mp[st] = true
                    return true
                }
                piles[i] += j
            }
        mp[st] = false
        return false
    }

}