class Solution2940 {
    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        val h = Array(heights.size) { mutableListOf<Pair<Int,Int>>() }
        val res = IntArray(queries.size) {-1}
        val st = mutableListOf<Pair<Int,Int>>()
        queries.forEachIndexed { i, p ->
            val (x,y) = p.min() to p.max()
            if (heights[y] > heights[x] || x == y) res[i] = y else h[y].add(heights[x] to i)
        }
        (heights.lastIndex downTo 0).forEach { i ->
            h[i].forEach { (x,y) ->
                var (l, r) = 0 to st.lastIndex
                var j = -1
                while (l<=r) {
                    val m = (l+r)/2
                    if (st[m].first > x) l = m+1.also{ j = maxOf(j, m) } else r = m - 1 }
                if (j in st.indices) res[y] = st[j].second
            }
            while (st.isNotEmpty() && st.last().first <= heights[i]) st.removeLast()
            st.add(heights[i] to i)
        }
        return res
    }
}
