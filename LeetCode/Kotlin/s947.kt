class Solution947 {
    fun removeStones(stones: Array<IntArray>): Int {
        var cnt = 0
        val m = mutableMapOf<Int, Int>()

        fun find(x: Int): Int {
            if (!m.containsKey(x)) m[x] = x .also {cnt++}
            if (x != m[x]) m[x] = find(m[x]!!)
            return m[x]!!
        }
        fun union(x: Int, y: Int) {
            val x = find(x)
            val y = find(y)
            if (x!=y) m[x] = y .also {cnt--}
        }
        stones.forEach { union(it[0], -(it[1]+1)) }
        return stones.size - cnt
    }
}
