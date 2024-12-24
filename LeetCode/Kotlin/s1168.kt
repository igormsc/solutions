class Solution1168 {
    fun minCostToSupplyWater(n: Int, wells: IntArray, pipes: Array<IntArray>): Int {
        var n = n
        val nums = pipes.copyOf(pipes.size + n)
        for (i in 0..<n)
            nums[pipes.size + i] = intArrayOf(0, i + 1, wells[i])
        nums.sortBy { it!![2] }
        val uf = UnionFind(n + 1)
        var res = 0
        for (x in nums) {
            val (a,b,c) = x!!
            if (uf.union(a, b)) {
                res += c
                if (--n == 0) break
            }
        }
        return res
    }

    internal class UnionFind(n: Int) {
        private val p = IntArray(n) {it}
        private val size = IntArray(n) {1}

        fun find(x: Int): Int {
            if (p[x] != x) p[x] = find(p[x])
            return p[x]
        }

        fun union(a: Int, b: Int): Boolean {
            val (pa, pb) = find(a) to find(b)
            if (pa == pb) return false
            if (size[pa] > size[pb]) {
                p[pb] = pa
                size[pa] += size[pb]
            } else {
                p[pa] = pb
                size[pb] += size[pa]
            }
            return true
        }
    }

}
