import java.util.*

class Solution2070 {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        val mp = TreeMap<Int, Int>()
        items.sortBy { it[0] }
        items.fold(0) { mx, (x, y) -> maxOf(mx, y).also{ mp[x] = it} }
        return queries.map { mp.floorEntry(it)?.value ?: 0 }.toIntArray()
    }
}

