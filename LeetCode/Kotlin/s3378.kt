class Solution3378 {
    fun countComponents(nums: IntArray, threshold: Int): Int {
        val ds = IntArray(threshold+1) {it}

        fun find(x: Int): Int = if (ds[x]==x) x else find(ds[x]).also{ds[x]=it}
        fun union(x: Int, y: Int) { ds[find(x)] = find(y) }

        nums.forEach{ n -> (n*2..threshold step n).forEach {union(n, it)}}
        val s = mutableSetOf<Int>()
        val cnt = nums.count{ n -> (n>threshold).also{ if (!it) s.add(find(n)) }}
        return cnt + s.size
    }
}

